package dao;

import java.util.List;

import model.Virement;

public interface VirementDao {
	public Virement findById(Integer i);
	public List <Virement> findAll();
	public void updateVirement(Virement v);
	public void removeVirement(Virement v);
	public void createVirement(Virement v);
}
