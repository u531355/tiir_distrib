package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.VirementDAO;
import model.Virement;

public class VirementDaoImpl extends DaoImpl <Integer, Virement >implements VirementDAO {
	public VirementDaoImpl() {
		super();
	}
	@Override
	public Virement findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List <Virement> findAll() {
		return super.lister();
	}

	@Override
	public void updateVirement(Virement v) {
		super.mettreAJour(v);
	}

	@Override
	public void removeVirement(Virement v) {
		super.supprimer(v.getIdVirement());
	}

	@Override
	public void createVirement(Virement v) {
		super.enregistrer(v);
	}

}
