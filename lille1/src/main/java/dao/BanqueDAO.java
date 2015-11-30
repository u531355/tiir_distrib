package dao;

import java.util.List;

import model.Banque;

public interface BanqueDAO {
	public Banque findById(Integer i);
	public Banque findByIban(Integer i);
	public List <Banque> findAll();
	public void removeBanque(Banque b);
	public void updateBanque(Banque b);
	public void createBanque(Banque b);
}
