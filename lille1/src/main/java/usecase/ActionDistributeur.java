package usecase;

import model.Banque;
import model.Distributeur;

public interface ActionDistributeur {
	Distributeur afficherSolde(Banque banque, String cardNumber);

	Distributeur retrait(Banque banque, String cardNumber, float montant);

	Distributeur virement(Banque banque, String cardNumber, float montant, String ibanTo);
}
