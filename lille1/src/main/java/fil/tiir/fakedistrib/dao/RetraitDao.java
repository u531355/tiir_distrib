package fil.tiir.fakedistrib.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fil.tiir.fakedistrib.entity.Retrait;

public interface RetraitDao {

	 
	/**
	 * Returns a list of all the retrait from the database
	 * @return
	 */
	List<Retrait> getAll();
	/**
	 * Save the retrait asked by the client in the Distributor database
	 * @param r
	 */
	void insert(Retrait r);
}
