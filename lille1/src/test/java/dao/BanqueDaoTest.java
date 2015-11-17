package dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import daoimpl.BanqueDaoImpl;
import model.Banque;

public class BanqueDaoTest {
	public static BanqueDaoImpl dao;
	public static EntityManagerFactory emf;
	@BeforeClass
	public static void setUp() {
		dao = new BanqueDaoImpl();
		 Persistence.createEntityManagerFactory("DAO-DB");
	}
	@Test
	public void test() {
		Banque b = new Banque(42, "toto");
		dao.createBanque(b);
		assertNotNull(dao.findById(b.getIdBanque()));
		dao.supprimer(b.getIdBanque());
		assertNull(dao.findById(b.getIdBanque()));
	}

}
