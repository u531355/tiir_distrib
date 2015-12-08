package dao;

import java.util.List;

import model.Distributeur;

public interface DistributeurDao {
	public Distributeur findById(Integer id);
	public List <Distributeur> findAll();
	public void removeDistributeur(Distributeur distrib);
	public void createDistributeur(Distributeur distrib);
	public void updateDistibuteur(Distributeur distrib);
}
