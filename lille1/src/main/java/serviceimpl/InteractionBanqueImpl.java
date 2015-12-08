package serviceimpl;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BanqueDao;
import dao.DistributeurDao;
import dao.RetraitDao;
import model.Banque;
import model.Client;
import model.Distributeur;
import model.Retrait;
import service.InteractionBanque;
import utils.SendRequest;

@Service
public class InteractionBanqueImpl implements InteractionBanque {
	public static final int END_ID_BANQUE = 5;
	public static final int ID_DISTRIBUTEUR = 42;
	public static final String LOGIN_URL = "/account";

	@Autowired
	private DistributeurDao distributeurDao;
	@Autowired
	private RetraitDao retraitDao;
	@Autowired
	private BanqueDao banqueDao;

	public boolean connecter(Client client) {
		Banque b = banqueDao.findByCardNumber(client.getNumeroCarte().substring(0, END_ID_BANQUE));
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		String content = "";
		JSONObject request = new JSONObject();
		request.put("card_number", client.getNumeroCarte().substring(END_ID_BANQUE));
		request.put("hashed_pin", client.getHash());
		content = request.toJSONString();
		String response = SendRequest.doRequest("POST", b.getUrl() + LOGIN_URL, params, content);
		if (response == null) {
			client.setConnected(false);
			return false;
		}
		JSONParser jsonresp = new JSONParser();
		try {
			Object o = jsonresp.parse(response);
			JSONObject array = (JSONObject) o;
			if (array.get("token") == null && (Integer) array.get("id_account") == 0
					&& array.get("end_of_validity") == null)
				return false;
			client.setToken((String) array.get("token"));
			client.setIdAccount((String) array.get("id_account"));
			client.setConnected(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.setBank(b);
		return true;
	}

	@Override
	public String afficherSolde(Client client) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		String response = SendRequest.doRequest("POST",
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
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		JSONObject json = new JSONObject();
		json.put("amount", montant);
		String response = SendRequest.doRequest("POST",
				client.getBank().getUrl() + "/" + client.getIdAccount() + "/" + "debit", params, json.toJSONString());
		if (response == null) {
			return null;
		}
		Distributeur d = distributeurDao.findById(ID_DISTRIBUTEUR);
		d.diminuerMontant(montant);
		distributeurDao.updateDistibuteur(d);
		return d;
	}

	@Override
	public Retrait virement(Client client, double montant, String ibanTo) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		params.put("Token", client.getToken());
		JSONObject json = new JSONObject();
		json.put("amount", montant);
		json.put("recipient", ibanTo.substring(InteractionBanqueImpl.END_ID_BANQUE));
		String response = SendRequest.doRequest("POST",
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
