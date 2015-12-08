package daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.VirementDao;
import model.Virement;

@SuppressWarnings("serial")
@Repository
public class VirementDaoImpl extends DaoImpl<Integer, Virement> implements VirementDao {
	public VirementDaoImpl() {
		super();
	}

	@Override
	public Virement findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List<Virement> findAll() {
		return super.lister();
	}

	@Override
	public void createVirement(Virement v) {
		super.enregistrer(v);
	}

}
