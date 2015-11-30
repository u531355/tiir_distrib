package daoimpl;

import java.util.List;

import dao.ClientDAO;
import model.Client;
import model.Distributeur;
import model.Client;

public class ClientDaoImpl extends DaoImpl<Integer, Client> implements ClientDAO  {
	public ClientDaoImpl() {
		super();
	}
	@Override
	public Client findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List<Client> findAll() {
		return super.lister();
	}
	
	public Client findByIban(Integer ibanStart) {
		return super.recherche("Select * from Client where iban_start=:iban_start",ibanStart);
	}

	@Override
	public void removeClient(Client b) {
		super.supprimer(b.getIdClient());
	}

	@Override
	public void updateClient(Client b) {
		super.mettreAJour(b);
	}

	@Override
	public void createClient(Client b) {
		// TODO Auto-generated method stub
		super.enregistrer(b);
	}

}
