package daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.DistributeurDao;
import model.Distributeur;

@SuppressWarnings("serial")
@Repository
public class DistributeurDaoImpl extends DaoImpl<Integer, Distributeur> implements DistributeurDao {
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
	public void createDistributeur(Distributeur distrib) {
		super.enregistrer(distrib);
	}

	@Override
	public void updateDistibuteur(Distributeur distrib) {
		super.mettreAJour(distrib);
	}

}
