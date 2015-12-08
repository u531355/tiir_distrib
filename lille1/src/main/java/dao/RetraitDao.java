package dao;

import java.util.List;

import model.Retrait;

public interface RetraitDao {
	Retrait findById(Integer i);

	List<Retrait> findAll();

	void createRetrait(Retrait r);
}
