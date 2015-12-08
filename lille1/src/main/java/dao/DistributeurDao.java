package dao;

import java.util.List;

import model.Distributeur;

public interface DistributeurDao {
	Distributeur findById(Integer id);

	List<Distributeur> findAll();

	void createDistributeur(Distributeur distrib);

	void updateDistibuteur(Distributeur distrib);
}
