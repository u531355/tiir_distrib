package fil.tiir.fakedistrib.dao;

import java.util.List;

import fil.tiir.fakedistrib.entity.Virement;

public interface VirementDao {
	/**
	 * returns the list of the Virement already make by the clients in this distributor
	 * @return
	 */
	List<Virement> getAll();
	/**
	 * Insert a virement make by the client into the distributor database
	 * @param v
	 */
	void insert(Virement v); 
}
