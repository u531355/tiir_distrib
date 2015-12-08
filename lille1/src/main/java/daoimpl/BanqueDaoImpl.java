package daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.BanqueDao;
import model.Banque;

@SuppressWarnings("serial")
@Repository
public class BanqueDaoImpl extends DaoImpl<Integer, Banque> implements BanqueDao {
	public BanqueDaoImpl() {
		super();
	}

	@Override
	public Banque findById(Integer i) {
		return super.rechercher(i);
	}

	@Override
	public List<Banque> findAll() {
		return super.lister();
	}

	public Banque findByCardNumber(String cardNumber) {
		return super.recherche("Select * from Banque where card_start=:card_start", cardNumber);
	}

	@Override
	public void removeBanque(Banque b) {
		super.supprimer(b.getIdBanque());
	}

	@Override
	public void createBanque(Banque b) {
		super.enregistrer(b);
	}

}
