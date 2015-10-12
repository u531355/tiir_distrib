package usecase;

import model.Client;
import model.Distributeur;

public interface ActionDistributeur {
	Distributeur afficherSolde(Client client);

	Distributeur retrait(Client client, double montant);

	Distributeur virement(Client client, double montant, String ibanTo);
}
