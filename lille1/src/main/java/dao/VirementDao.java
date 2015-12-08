package dao;

import java.util.List;

import model.Virement;

public interface VirementDao {
	Virement findById(Integer i);

	List<Virement> findAll();

	void createVirement(Virement v);
}
