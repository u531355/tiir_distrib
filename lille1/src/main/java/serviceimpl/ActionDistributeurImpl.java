package serviceimpl;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DistributeurDao;
import dao.RetraitDao;
import model.Client;
import model.Distributeur;
import model.Retrait;
import service.ActionDistributeur;
import utils.SendRequest;

@Service
public class ActionDistributeurImpl implements ActionDistributeur {
	public static final int ID_DISTRIBUTEUR = 42;

	@Autowired
	private DistributeurDao distributeurDao;
	@Autowired
	private RetraitDao retraitDao;

	@Override
	public String afficherSolde(Client client) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		String response = SendRequest.do_request("POST",
				client.getBank().getUrl() + "/" + client.getIdAccount() + "/" + "balance", params, "");
		if (response == null) {
			return null;
		}
		JSONParser jsonresp = new JSONParser();
		try {
			Object o = jsonresp.parse(response);
			JSONObject array = (JSONObject) o;
			return (String) array.get("balance");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Distributeur retrait(Client client, double montant) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		JSONObject json = new JSONObject();
		json.put("amount", montant);
		String response = SendRequest.do_request("POST",
				client.getBank().getUrl() + "/" + client.getIdAccount() + "/" + "debit", params, json.toJSONString());
		if (response == null) {
			return null;
		}
		Distributeur d = distributeurDao.findById(ID_DISTRIBUTEUR);
		d.setMontant(d.getMontant() - montant);
		distributeurDao.updateDistibuteur(d);
		return d;
	}

	@Override
	public Retrait virement(Client client, double montant, String ibanTo) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		JSONObject json = new JSONObject();
		json.put("amount", montant);
		json.put("recipient", ibanTo.substring(InteractionBanqueImpl.END_ID_BANQUE));
		String response = SendRequest.do_request("POST",
				client.getBank().getUrl() + "/" + client.getIdAccount() + "/" + "transfer", params,
				json.toJSONString());
		if (response == null) {
			return null;
		}
		Retrait r = new Retrait(Integer.parseInt(client.getNumeroCarte()), Integer.parseInt(ibanTo), montant);
		retraitDao.createRetrait(r);
		return r;
	}

}
