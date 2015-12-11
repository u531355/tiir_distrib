package fil.tiir.fakedistrib.dao;

import java.util.List;

import fil.tiir.fakedistrib.entity.Distributeur;

public interface DistributeurDao {
	/**
	 * returns the list of Distributor from the database
	 * @return
	 */
	List<Distributeur> getAll();
	/**
	 * update the distributor d in the database
	 * @param d
	 */
	void update(Distributeur d);
}
