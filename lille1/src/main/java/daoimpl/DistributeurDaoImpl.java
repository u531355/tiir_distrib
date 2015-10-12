package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.DistributeurDAO;
import model.Distributeur;

public class DistributeurDaoImpl implements DistributeurDAO {
	private EntityManager em;

	@Override
	public Distributeur findById(Integer id) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select d from Distributeur d where id_distributeur = :id_distributeur");
		q.setParameter("id_distributeur", id);
		return (Distributeur) q.getSingleResult();
	}

	@Override
	public List<Distributeur> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select d from Distributeur d");
		return (List<Distributeur>) q.getResultList();
	}

	@Override
	public void removeDistributeur(Distributeur distrib) {
		// TODO Auto-generated method stub
		em.remove(distrib);
	}

	@Override
	public void createDistributeur(Distributeur distrib) {
		// TODO Auto-generated method stub
		em.persist(distrib);
	}

	@Override
	public void updateDistibuteur(Distributeur distrib) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("update Distributeur d set d.solde = :montant where id_distributeur = :id_distributeur");
		q.setParameter(":id_distributeur", distrib.getIdDistributeur());
		q.setParameter("solde", distrib.getSolde());
		q.executeUpdate();
	}

}
