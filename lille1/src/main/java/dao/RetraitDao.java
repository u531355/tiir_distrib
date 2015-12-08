package dao;

import java.util.List;

import model.Retrait;

public interface RetraitDao {
	public Retrait findById(Integer i);
	public List <Retrait> findAll();
	public void createRetrait(Retrait r);
	public void deleteRetrait(Retrait r);
	public void updateRetrait(Retrait r);
}
