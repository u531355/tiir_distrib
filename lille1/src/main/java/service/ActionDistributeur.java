package service;

import model.Client;
import model.Distributeur;
import model.Retrait;

public interface ActionDistributeur {
	String afficherSolde(Client client);

	Distributeur retrait(Client client, double montant);

	Retrait virement(Client client, double montant, String ibanTo);
}
