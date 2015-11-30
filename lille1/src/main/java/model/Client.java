package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import daoimpl.BanqueDaoImpl;

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_client")
	private Integer idClient;
	@Transient
	private Banque myBank;
	private String iban;
	private String token;
	public Client() {
		
	}
	public Client(String iban, String token) {
		this.iban = iban;
		this.token = token;
		myBank = new BanqueDaoImpl().findByIban(Integer.parseInt(iban.substring(0, 4)));
	}
	public Integer getIdClient() {
		return idClient;
	}
	public Banque getMyBank() {
		return myBank;
	}

	public String getIban() {
		return iban;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	

}
