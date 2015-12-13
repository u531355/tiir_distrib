package fil.tiir.fakedistrib.service;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.entity.Retrait;
import fil.tiir.fakedistrib.entity.Virement;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;
/**
 * Interface of the Bank service
 * @author blanquart
 *
 */
public interface InteractionBanque {
	/**
	 * Service that create an account, contact the bank and create an account
	 * A InteractionBanqueException is Generated when the bank don't respond 
	 * @param A client
	 * @throws InteractionBanqueException
	 */
	void creerCompte(Client client) throws InteractionBanqueException;
	/**
	 * Take the information from the client object and ask the bank if the Information are correct
	 * If the information is correct, the service fill the client object with the information received
	 * @param client
	 * @throws InteractionBanqueException
	 */
	void connecter(Client client) throws InteractionBanqueException;
	/**
	 * Consume the Token in the client object and Display the sum available in the Account_Id account
	 * @param client
	 * @return
	 * @throws InteractionBanqueException
	 */
	String afficherSolde(Client client) throws InteractionBanqueException;
	/**
	 * Verify if the Distributor has enough cash, if there are enough cash, Consume the token and retire the Sum from the client account
	 * save the transaction in the Database
	 * @param client
	 * @param retrait
	 * @throws InteractionBanqueException
	 */
	void retrait(Client client, Retrait retrait) throws InteractionBanqueException;
	/**
	 * Consume the token and give the sum from the client Account_id at the Virement Account_from
	 * @param client
	 * @param virement
	 * @throws InteractionBanqueException
	 */
	void virement(Client client, Virement virement) throws InteractionBanqueException;
	/**
	 * Remove the Token generated at the bank
	 * @param client
	 * @throws InteractionBanqueException
	 */
	void suppressionToken(Client client) throws InteractionBanqueException;
	
	
	void depot(Client client, int amount) throws InteractionBanqueException;
}
