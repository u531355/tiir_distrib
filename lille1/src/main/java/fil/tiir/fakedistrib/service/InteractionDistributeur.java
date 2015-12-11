/**
 * 
 */
package fil.tiir.fakedistrib.service;

/**
 * @author blanquart
 *	Interface of the Distributor Service
 */
public interface InteractionDistributeur {
	/**
	 * Check if the distributor has enough cash in the cash bank
	 * @param montant
	 * @return
	 */
	public boolean isEnoughCash(int montant);
	/**
	 * retire cash from the distributor
	 * @param montant
	 */
	public void retireCash(int montant);
}