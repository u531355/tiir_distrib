package serviceimpl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BanqueDao;
import dao.DistributeurDao;
import dao.RetraitDao;
import model.Banque;
import model.Client;
import service.InteractionBanque;

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
		System.out.println("UN TEST");
		System.out.println(client.getNumeroCarte());
		Banque b = banqueDao.findByCardNumber(client.getNumeroCarte().substring(0, END_ID_BANQUE));
		JSONObject request = new JSONObject();

		try {
			request.append("card_number", client.getNumeroCarte().substring(END_ID_BANQUE));
			request.append("hashed_pin", client.getHash());
			String response = sendRequest(request, b.getUrl() + "/token");

			if (response == null) {
				client.setConnected(false);
				return false;
			}

			JSONObject jResponse = new JSONObject(response);

			String token = jResponse.getString("token");
			String id = jResponse.getString("id_account");
			String validity = (String) jResponse.get("end_of_validity");

			if (token == null || id == "0" || validity == null)
				return false;
			client.setToken(token);
			client.setIdAccount(id);
			client.setConnected(true);
		} catch (IOException | JSONException e) {
			return false;
		}
		client.setBank(b);
		return true;
	}

	@Override
	public String afficherSolde(Client client) {
		return "";
	}

	@Override
	public boolean retrait(Client client, double montant) {
		return true;
	}

	@Override
	public boolean virement(Client client, double montant, String ibanTo) {
		return true;
	}

	public static String sendRequest(JSONObject toSend, String url) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		StringEntity params = new StringEntity(toSend.toString());
		request.addHeader("content-type", "application/json");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);
		httpClient.close();
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		return responseString;
	}

}
