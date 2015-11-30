package service;

import org.springframework.stereotype.Service;

import model.Banque;
import model.Client;

@Service
public interface InteractionBanque {
	Banque connecter(Client client);
}
