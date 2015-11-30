package daoimpl;

import java.util.List;

import dao.BanqueDAO;
import model.Banque;

@SuppressWarnings("serial")
public class BanqueDaoImpl extends DaoImpl<Integer, Banque> implements BanqueDAO {
	public BanqueDaoImpl() {
		super();
	}

	@Override
	public Banque findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List<Banque> findAll() {
		return super.lister();
	}
	
	public Banque findByIban(Integer ibanStart) {
		return super.recherche("Select * from Banque where iban_start=:iban_start",ibanStart);
	}

	@Override
	public void removeBanque(Banque b) {
		super.supprimer(b.getIdBanque());
	}

	@Override
	public void updateBanque(Banque b) {
		super.mettreAJour(b);
	}

	@Override
	public void createBanque(Banque b) {
		// TODO Auto-generated method stub
		super.enregistrer(b);
	}

}
