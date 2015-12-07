package serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.DistributeurDAO;
import daoimpl.DistributeurDaoImpl;
import model.Client;
import model.Distributeur;
import service.ActionDistributeur;
import utils.SendRequest;

public class ActionDistributeurImpl implements ActionDistributeur {
	public static final int ID_DISTRIBUTEUR = 42;
	@Override
	public String afficherSolde(Client client) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String,String> ();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		String content = "";
		String response = SendRequest.do_request("POST", client.getBank().getUrl()+"/"+client.getIdAccount()+"/"+"balance", params, "");
		if(response == null) {
			return null;
		}
		JSONParser jsonresp = new JSONParser();
		try {
			Object o = jsonresp.parse(response);
			JSONArray array = (JSONArray) o;
			return (String)array.get(0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Distributeur retrait(Client client, double montant) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String,String> ();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		JSONObject json = new JSONObject();
		json.put("amount", montant);
		String content = "";
		String response = SendRequest.do_request("POST", client.getBank().getUrl()+"/"+client.getIdAccount()+"/"+"debit", params, json.toJSONString());
		if(response == null) {
			return null;
		}
		DistributeurDAO ddao = new DistributeurDaoImpl();
		Distributeur d = ddao.findById(ID_DISTRIBUTEUR);
		d.setMontant(d.getMontant() - montant);
		ddao.updateDistibuteur(d);
		return d;
	}

	@Override
	public Distributeur virement(Client client, double montant, String ibanTo) {
		// TODO Auto-generated method stub
		return null;
	}

}
