package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.RetraitDAO;
import model.Retrait;

public class RetraitDaoImpl implements RetraitDAO {
	private EntityManager em;
	@Override
	public Retrait findById(Integer i) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Select r from Retrait where id_retrait = :id_retrait ");
		q.setParameter("id_retrait", i);
		return (Retrait) q.getSingleResult();
	}

	@Override
	public List<Retrait> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Select * from Retrait");
		return (List <Retrait>) q.getResultList();
	}

	@Override
	public void createRetrait(Retrait r) {
		// TODO Auto-generated method stub
		em.persist(r);
	}

	@Override
	public void deleteRetrait(Retrait r) {
		// TODO Auto-generated method stub
		em.remove(r);
	}

	@Override
	public void updateRetrait(Retrait r) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("update Retrait r set r.montant = :montant, r.date = :date, r.id_banque = :id_banque,"
				+ "r.iban_from = :iban_from where id_retrait = :id_retrait");
		q.setParameter("montant", r.getMontant());
		q.setParameter("date", r.getDate());
		q.setParameter("id_banque", r.getIdBanque());
		q.setParameter("iban_from", r.getIbanFrom());
		q.setParameter("id_retrait", r.getIdRetrait());
		q.executeUpdate();
	}

}
