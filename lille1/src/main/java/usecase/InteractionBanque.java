package usecase;

import model.Banque;

public interface InteractionBanque {
	Banque connecter(String iban, String cardNumber, String password);
}
