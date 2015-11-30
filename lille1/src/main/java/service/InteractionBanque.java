package service;

import model.Banque;
import model.Client;

public interface InteractionBanque {
	Banque connecter(Client client);
	
	
}
