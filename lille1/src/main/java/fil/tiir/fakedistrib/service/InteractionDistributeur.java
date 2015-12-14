/**
 * 
 */
package fil.tiir.fakedistrib.service;

import fil.tiir.fakedistrib.exception.InteractionDistributeurException;

/**
 * @author blanquart Interface of the Distributor Service
 */
public interface InteractionDistributeur {
	/**
	 * Check if the distributor has enough cash in the cash bank
	 * 
	 * @param montant
	 * @throws InteractionDistributeurException
	 */
	public void isEnoughCash(int montant) throws InteractionDistributeurException;

	/**
	 * retire cash from the distributor
	 * 
	 * @param montant
	 */
	public void retireCash(int montant);
}