package fil.tiir.fakedistrib.dao;

import java.util.List;

import fil.tiir.fakedistrib.entity.Banque;

public interface BanqueDao {
	List<Banque> getAll();
	/**
	 * Take a cardNumber and returns the Bank who generates this cardNumber
	 * @param cardNumber
	 * @return
	 */
	Banque findByCardNumber(String cardNumber);
}
