package daoimpl;

import java.util.List;

import dao.DistributeurDAO;
import model.Distributeur;

@SuppressWarnings("serial")
public class DistributeurDaoImpl extends DaoImpl<Integer, Distributeur> implements DistributeurDAO {
	public DistributeurDaoImpl() {
		super();
	}

	@Override
	public Distributeur findById(Integer id) {
		return super.rechercher(id);
	}

	@Override
	public List<Distributeur> findAll() {
		return super.lister();
	}

	@Override
	public void removeDistributeur(Distributeur distrib) {
		super.supprimer(distrib.getIdDistributeur());
	}

	@Override
	public void createDistributeur(Distributeur distrib) {
		super.enregistrer(distrib);
	}

	@Override
	public void updateDistibuteur(Distributeur distrib) {
		super.mettreAJour(distrib);
	}

}
