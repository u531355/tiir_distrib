package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.VirementDAO;
import model.Virement;

public class VirementDaoImpl implements VirementDAO {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Virement findById(Integer i) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Select v from Virement where id_banque = :id_banque ");
		q.setParameter("id_banque", i);
		return (Virement) q.getSingleResult();
		
	}

	@Override
	public List <Virement> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Select v from Virement");
		return (List <Virement>) q.getResultList();
	}

	@Override
	public void updateVirement(Virement v) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("Update Virement set ");
	}

	@Override
	public void removeVirement(Virement v) {
		// TODO Auto-generated method stub
		em.remove(v);
	}

	@Override
	public void createVirement(Virement v) {
		// TODO Auto-generated method stub
		em.persist(v);
	}

}
