package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BanqueDAO;
import model.Banque;

public class BanqueDaoImpl extends DaoImpl <Integer, Banque> implements BanqueDAO {
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
