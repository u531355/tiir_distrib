package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BanqueDAO;
import model.Banque;

public class BanqueDaoImpl implements BanqueDAO {
	private EntityManager em;
	@Override
	public Banque findById(Integer i) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Select b from Banque b where id_banque = :id_banque");
		return (Banque) q.getSingleResult();
	}

	@Override
	public List<Banque> findAll() {
		Query q = em.createQuery("Select b from Banque b");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBanque(Banque b) {
		// TODO Auto-generated method stub
		em.remove(b);
	}

	@Override
	public void updateBanque(Banque b) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Update Banque b set b.iban_start = :iban_start, b.url = :url "
				+ "b.id_banque = :id_banque");
		q.setParameter("iban_start", b.getIbanStart());
		q.setParameter("url", b.getUrl());
		q.setParameter("id_banque", b.getIdBanque());
		q.executeUpdate();
	}

	@Override
	public void createBanque(Banque b) {
		// TODO Auto-generated method stub
		em.persist(b);
	}

}
