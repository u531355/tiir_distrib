package model;


import daoimpl.BanqueDaoImpl;

public class Client {
	private String iban;
	private String token;
	private String hash;
	private String idAccount;
	public Client() {
		
	}
	public Client(String iban, String hash) {
		this.iban = iban;
		this.hash = hash;
		this.token = null;
		this.idAccount = null;
	}

	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}
	


}
