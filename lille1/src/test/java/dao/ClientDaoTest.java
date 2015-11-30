package dao;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daoimpl.ClientDaoImpl;
import model.Client;

@RestController
public class ClientDaoTest {

	private Integer testAdd(String iban, String token) {
		ClientDAO b = new ClientDaoImpl();
		Client obj = new Client(iban, token);
		b.createClient(obj);
		System.out.println( "AJOUT : OK ; ID : " + obj.getIdClient());
		return obj.getIdClient();
	}
	
	private void testRemove(Client obj) {
		ClientDAO b = new ClientDaoImpl();
		b.removeClient(obj);
		System.out.println("REMOVE : OK");
	}
	private Client testFind(Integer id) {
		ClientDAO b = new ClientDaoImpl();
		Client obj = b.findById(id);
		System.out.println("FIND : OK");
		return obj;
	}
	private Client testFindByIban(int iban) {
		ClientDAO b = new ClientDaoImpl();
		Client obj = b.findByIban(iban);
		System.out.println("FINDIBAN : OK");
		return obj;
	}
	private void testUpdateClient(Client obj, String token) {
		ClientDAO b = new ClientDaoImpl();
		obj.setToken(token);
		b.updateClient(obj);
		System.out.println("Client UPDATE : OK");
	}
	@RequestMapping("/ClientDaoTest")
	public String testClientDAO(@RequestParam(value = "iban", defaultValue = "42697") String iban,@RequestParam(value = "token", defaultValue = "42") String token) {
		Integer ClientId = testAdd(iban, token);
		Client b = testFind(ClientId);
		Client b2 = testFindByIban(Integer.parseInt(iban));
		testUpdateClient(b, "43");
		testRemove(b);
		return "ALL OK";
	}	
}
	