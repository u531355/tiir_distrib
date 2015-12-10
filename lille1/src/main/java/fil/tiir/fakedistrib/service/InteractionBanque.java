package fil.tiir.fakedistrib.service;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;

public interface InteractionBanque {
	/**
	 * @param client
	 * @return
	 */
	void connecter(Client client) throws InteractionBanqueException;

	/**
	 * Display the solde of the client in this account
	 * 
	 * @param client
	 * @return
	 */
	String afficherSolde(Client client) throws InteractionBanqueException;

	/**
	 * retire the sum of the client's account, look if the distributor has
	 * enough money to give the client and give it
	 * 
	 * @param client
	 * @param montant
	 * @return
	 */
	boolean retrait(Client client, double montant) throws InteractionBanqueException;

	/**
	 * transfer montant euro from the client to the IbanTo Account
	 * 
	 * @param client
	 * @param montant
	 * @param ibanTo
	 * @return
	 */
	boolean virement(Client client, double montant, String ibanTo) throws InteractionBanqueException;

}
