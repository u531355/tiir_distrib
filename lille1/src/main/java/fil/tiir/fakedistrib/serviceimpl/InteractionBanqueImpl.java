package fil.tiir.fakedistrib.serviceimpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.tiir.fakedistrib.dao.BanqueDao;
import fil.tiir.fakedistrib.dao.RetraitDao;
import fil.tiir.fakedistrib.dao.VirementDao;
import fil.tiir.fakedistrib.entity.Banque;
import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Retrait;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;
import fil.tiir.fakedistrib.util.RequestUtil;
/**
 * A implementation of the Bank service interface
 * @author blanquart
 *
 */
@Service
public class InteractionBanqueImpl implements InteractionBanque {

	@Autowired
	private BanqueDao banqueDao;
	@Autowired
	private RetraitDao retraitDao;
	@Autowired
	private VirementDao virementDao;

	@Override
	public void creerCompte(Client client) throws InteractionBanqueException {
		// TODO The function was made, but a problem : how to know what bank we give the request? I assume here the bank was given into the client object
		Banque b = banqueDao.findByCardNumber(client.getNumeroCarte());
		if (b == null)
			throw new InteractionBanqueException("Cette banque n'existe pas.");
		String response;
		try {
			response = RequestUtil.sendBasicPostRequest(b, "account");
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		}
		System.out.println(response);
	}

	@Override
	public void connecter(Client client) throws InteractionBanqueException {
		Banque b = banqueDao.findByCardNumber(client.getNumeroCarte());
		if (b == null)
			throw new InteractionBanqueException("Cette banque n'existe pas.");

		JSONObject request = new JSONObject();
		

		try {
			request.append("card_number", Integer.parseInt(client.getNumeroCarte()));
			request.append("hashed_pin", client.getHash());
		} catch (JSONException e) {
			throw new InternalError();
		}

		String response;
		try {
			response = RequestUtil.sendRequest(request, b, "token");
		} catch (IOException e) {
			e.printStackTrace();
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new InteractionBanqueException("Erreur de paramètres.");
			
		}
		System.out.println(response.toString());
		String token, id; 
		long validity;
		try {
			JSONObject jResponse = new JSONObject(response);
			token = jResponse.getString("token");
			id = jResponse.getString("id_account");
			validity = (long) jResponse.get("end_of_validity");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new InteractionBanqueException("La banque a montré un comportement inatendu.");
		}
		if (token == null || id.equals("0") )
			throw new InteractionBanqueException("Numéro de carte ou mot de passe incorrect.");

		// Client is legit
		client.setToken(token);
		client.setIdAccount(id);
		client.setBank(b);
	}

	@Override
	public String afficherSolde(Client client) throws InteractionBanqueException {
		JSONObject request = new JSONObject();
		String url = "account/" + client.getIdAccount() + "/balance";
		String response;
		try {
			response = RequestUtil.sendRequest(request, client.getBank(), url, client.getToken());
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		} catch (JSONException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
			
		}

		String balance;
		try {
			JSONObject jResponse = new JSONObject(response);
			balance = jResponse.getString("balance");
		} catch (JSONException e) {
			throw new InteractionBanqueException("La banque a montré un comportement inatendu.");
		}
		return balance;
	}

	@Override
	public void retrait(Client client, Retrait retrait) throws InteractionBanqueException {
		JSONObject request = new JSONObject();
		try {
			request.append("amount", retrait.getMontant());
		} catch (JSONException e1) {
			throw new InternalError();
		}
		String url = "account/" + client.getIdAccount() + "/debit";
		String response;
		try {
			response = RequestUtil.sendRequest(request, client.getBank(), url, client.getToken());
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		} catch (JSONException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
			
		}
	}

	@Override
	public void virement(Client client, Virement virement) throws InteractionBanqueException {
		JSONObject request = new JSONObject();

		try {
			request.append("amount", virement.getMontant());
			request.append("recipient", virement.getIbanTo());
		} catch (JSONException e) {
			throw new InternalError();
		}
		String url = "account/" + client.getIdAccount() + "/transfert";
		String response;
		try {
			response = RequestUtil.sendRequest(request, client.getBank(), url, client.getToken());
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		} catch (JSONException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
			
		}
	}

	@Override
	public void suppressionToken(Client client) throws InteractionBanqueException {

		String url = "token/" + client.getToken();
		
		try{
			RequestUtil.sendDeleteRequest(client.getBank(), url);
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		}
		
	}

}
