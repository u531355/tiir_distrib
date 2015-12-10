package fil.tiir.fakedistrib.dao;

import java.util.List;

import fil.tiir.fakedistrib.entity.Banque;

public interface BanqueDao {
	List<Banque> getAll();

	Banque findByCardNumber(String cardNumber);
}
