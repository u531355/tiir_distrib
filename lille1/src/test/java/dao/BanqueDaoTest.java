package dao;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daoimpl.BanqueDaoImpl;
import model.Banque;

@RestController
public class BanqueDaoTest {

	private Integer testAdd(String ibanStart, String url) {
		BanqueDAO b = new BanqueDaoImpl();
		Banque obj = new Banque(Integer.parseInt(ibanStart), url);
		b.createBanque(obj);
		System.out.println( "AJOUT : OK ; ID : " + obj.getIdBanque());
		return obj.getIdBanque();
	}
	
	private void testRemove(Banque obj) {
		BanqueDAO b = new BanqueDaoImpl();
		b.removeBanque(obj);
		System.out.println("REMOVE : OK");
	}
	private Banque testFind(Integer id) {
		BanqueDAO b = new BanqueDaoImpl();
		Banque obj = b.findById(id);
		System.out.println("FIND : OK");
		return obj;
	}
	private Banque testFindByIban(int iban) {
		BanqueDAO b = new BanqueDaoImpl();
		Banque obj = b.findByIban(iban);
		System.out.println("FINDIBAN : OK");
		return obj;
	}
	private void testUpdateBanque(Banque obj, int iban, String url) {
		BanqueDAO b = new BanqueDaoImpl();
		obj.setIbanStart(iban);
		obj.setUrl(url);
		b.updateBanque(obj);
		System.out.println("BANQUE UPDATE : OK");
	}
	@RequestMapping("/BanqueDaoTest")
	public String testBanqueDAO(@RequestParam(value = "ibanstart", defaultValue = "4269") String ibanStart,@RequestParam(value = "url", defaultValue = "www.google.fr") String url) {
		Integer banqueId = testAdd(ibanStart, url);
		Banque b = testFind(banqueId);
		Banque b2 = testFindByIban(Integer.parseInt(ibanStart));
		testUpdateBanque(b, 4270, url);
		testRemove(b);
		return "ALL OK";
		
	}
	
}