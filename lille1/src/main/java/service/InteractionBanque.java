package service;

import org.springframework.stereotype.Service;

import model.Client;


public interface InteractionBanque {
	boolean connecter(Client client);
}
