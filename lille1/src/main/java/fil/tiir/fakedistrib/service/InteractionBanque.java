package fil.tiir.fakedistrib.service;

import java.io.IOException;

import org.json.JSONException;

import fil.tiir.fakedistrib.entity.Client;

public interface InteractionBanque {
	/**
	 * @param client
	 * @return
	 */
	void connecter(Client client) throws JSONException, IOException;

	/**
	 * Display the solde of the client in this account
	 * 
	 * @param client
	 * @return
	 */
	String afficherSolde(Client client);

	/**
	 * retire the sum of the client's account, look if the distributor has
	 * enough money to give the client and give it
	 * 
	 * @param client
	 * @param montant
	 * @return
	 */
	boolean retrait(Client client, double montant);

	/**
	 * transfer montant euro from the client to the IbanTo Account
	 * 
	 * @param client
	 * @param montant
	 * @param ibanTo
	 * @return
	 */
	boolean virement(Client client, double montant, String ibanTo);

}
