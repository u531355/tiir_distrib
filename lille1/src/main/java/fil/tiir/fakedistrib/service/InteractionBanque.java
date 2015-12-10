package fil.tiir.fakedistrib.service;

import fil.tiir.fakedistrib.entity.Client;
import fil.tiir.fakedistrib.exception.InteractionBanqueException;

public interface InteractionBanque {
	void connecter(Client client) throws InteractionBanqueException;

	String afficherSolde(Client client) throws InteractionBanqueException;

	void retrait(Client client, double montant) throws InteractionBanqueException;

	void virement(Client client, double montant, String ibanTo) throws InteractionBanqueException;
}
