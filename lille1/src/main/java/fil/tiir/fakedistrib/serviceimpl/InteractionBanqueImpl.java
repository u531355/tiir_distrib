package fil.tiir.fakedistrib.serviceimpl;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.tiir.fakedistrib.dao.BanqueDao;
import fil.tiir.fakedistrib.dao.RetraitDao;
import fil.tiir.fakedistrib.dao.VirementDao;
import fil.tiir.fakedistrib.entity.Banque;
import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
import fil.tiir.fakedistrib.service.InteractionBanque;
import fil.tiir.fakedistrib.util.RequestUtil;

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
		// TODO il n'y a rien à envoyer dans la requête, juste une réponse à
		// afficher, donc pas besoin de formulaire dans le .html etc ...
		Banque b = banqueDao.findByCardNumber(client.getNumeroCarte());
		if (b == null)
			throw new InteractionBanqueException("Cette banque n'existe pas.");
		JSONObject request = new JSONObject();
		try {
			request.append("id_account", client.getIdAccount());
			request.append("card_number", client.getNumeroCarteSansStart());
			request.append("balance", Integer.toString(client.getMontant()));
		} catch (JSONException e) {
			throw new InternalError();
		}

		String response;
		try {
			response = RequestUtil.sendRequest(request, b, "account");
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
			request.append("card_number", client.getNumeroCarteSansStart());
			request.append("hashed_pin", client.getHash());
		} catch (JSONException e) {
			throw new InternalError();
		}

		String response;
		try {
			response = RequestUtil.sendRequest(request, b, "token");
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		}

		String token, id, validity;
		try {
			JSONObject jResponse = new JSONObject(response);
			token = jResponse.getString("token");
			id = jResponse.getString("id_account");
			validity = (String) jResponse.get("end_of_validity");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new InteractionBanqueException("La banque a montré un comportement inatendu.");
		}
		if (token == null || id.equals("0") || validity == null)
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
	public void retrait(Client client, double montant) throws InteractionBanqueException {
		JSONObject request = new JSONObject();
		try {
			request.append("amount", montant);
		} catch (JSONException e1) {
			throw new InternalError();
		}
		String url = "account/" + client.getIdAccount() + "/debit";
		String response;
		try {
			response = RequestUtil.sendRequest(request, client.getBank(), url, client.getToken());
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		}
	}

	@Override
	public void virement(Client client, double montant, String ibanTo) throws InteractionBanqueException {
		JSONObject request = new JSONObject();

		try {
			request.append("amount", montant);
			request.append("recipient", ibanTo);
		} catch (JSONException e) {
			throw new InternalError();
		}
		String url = "account/" + client.getIdAccount() + "/transfert";
		String response;
		try {
			response = RequestUtil.sendRequest(request, client.getBank(), url, client.getToken());
		} catch (IOException e) {
			throw new InteractionBanqueException("Erreur de communication avec la banque.");
		}
	}

}
