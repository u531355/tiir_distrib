package service;

import org.springframework.stereotype.Service;

import model.Client;
import model.Distributeur;


public interface ActionDistributeur {
	String afficherSolde(Client client);

	Distributeur retrait(Client client, double montant);

	Distributeur virement(Client client, double montant, String ibanTo);
}
