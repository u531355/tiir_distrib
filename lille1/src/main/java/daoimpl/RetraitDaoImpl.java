package daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.RetraitDao;
import model.Retrait;

@SuppressWarnings("serial")
@Repository
public class RetraitDaoImpl extends DaoImpl<Integer, Retrait> implements RetraitDao {
	public RetraitDaoImpl() {
		super();
	}

	@Override
	public Retrait findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List<Retrait> findAll() {
		return super.lister();
	}

	@Override
	public void createRetrait(Retrait r) {
		super.enregistrer(r);
	}

}
