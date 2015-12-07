package service;

import org.springframework.stereotype.Service;

import model.Client;
import model.Distributeur;

import model.Retrait;
/**
 * Interface designing the differents actions available for the distributor
 * @author blanquart
 *
 */

public interface ActionDistributeur {
	/**
	 * Display the solde of the client in this account
	 * @param client
	 * @return
	 */
	String afficherSolde(Client client);
	/**
	 * retire the sum of the client's account, look if the distributor has enough money to give the client and give it 
	 * @param client
	 * @param montant
	 * @return
	 */
	Distributeur retrait(Client client, double montant);
	/**
	 * transfer montant euro from the client to the IbanTo Account
	 * @param client
	 * @param montant
	 * @param ibanTo
	 * @return
	 */
	Retrait virement(Client client, double montant, String ibanTo);
}
