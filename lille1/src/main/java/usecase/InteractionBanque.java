package usecase;

import model.Banque;

public interface InteractionBanque {
	Banque connecter(String cardNumber, String password);
}
