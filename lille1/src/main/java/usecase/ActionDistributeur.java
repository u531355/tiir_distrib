package usecase;

import model.Client;
import model.Distributeur;

public interface ActionDistributeur {
	Distributeur afficherSolde(Client client);

	Distributeur retrait(Client client, float montant);

	Distributeur virement(Client client, float montant, String ibanTo);
}
