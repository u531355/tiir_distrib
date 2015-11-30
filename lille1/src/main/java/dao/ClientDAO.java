package dao;

import java.util.List;

import model.Client;


public interface ClientDAO {
	public Client findById(Integer i);
	public Client findByIban(Integer i);
	public List <Client> findAll();
	public void removeClient(Client b);
	public void updateClient(Client b);
	public void createClient(Client b);
}
