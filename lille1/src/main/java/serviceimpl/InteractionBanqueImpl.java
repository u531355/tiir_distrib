package serviceimpl;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import dao.BanqueDAO;
import daoimpl.BanqueDaoImpl;
import model.Banque;
import model.Client;
import service.InteractionBanque;
import utils.SendRequest;

@Service
@Scope("singleton")
public class InteractionBanqueImpl implements InteractionBanque {
	public static final int END_ID_BANQUE = 5;
	public static final String LOGIN_URL = "/account";

	public boolean connecter(Client client) {
		BanqueDAO banquedao = new BanqueDaoImpl();
		Banque b = banquedao.findByIban(client.getNumeroCarte().substring(0, END_ID_BANQUE));
		HashMap<String, String> params = new HashMap<String,String> ();
		params.put("Content-Type", "application/json");
		String content = "";
		JSONObject request = new JSONObject();
		request.put("card_number", client.getNumeroCarte().substring(END_ID_BANQUE));
		request.put("hashed_pin", client.getHash());
		content = request.toJSONString();
		String response = SendRequest.do_request("POST", b.getUrl()+LOGIN_URL, params, content);
		if(response == null) {
			client.setConnected(false);
			return false;
		}
		JSONParser jsonresp = new JSONParser();
		try {
			Object o = jsonresp.parse(response);
			JSONArray array = (JSONArray) o;
			client.setToken((String)array.get(0));
			client.setIdAccount((String)array.get(2));
			client.setConnected(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.setBank(b);
		return true;
	}

}
