package dao;

import java.util.List;

import model.Banque;

public interface BanqueDao {
	Banque findById(Integer i);

	Banque findByCardNumber(String i);

	List<Banque> findAll();

	void removeBanque(Banque b);

	void createBanque(Banque b);
}
