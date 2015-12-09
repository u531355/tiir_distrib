package fil.tiir.fakedistrib.dao;

import fil.tiir.fakedistrib.entity.Banque;

public interface BanqueDao {
	Banque findByCardNumber(String cardNumber);
}
