package daoimpl;

import java.util.List;

import dao.RetraitDAO;
import model.Retrait;

@SuppressWarnings("serial")
public class RetraitDaoImpl extends DaoImpl<Integer, Retrait> implements RetraitDAO {
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

	@Override
	public void deleteRetrait(Retrait r) {
		super.supprimer(r.getIdRetrait());
	}

	@Override
	public void updateRetrait(Retrait r) {
		super.mettreAJour(r);
	}

}
