package model;


import daoimpl.BanqueDaoImpl;

public class Client {
	private String numeroCarte;
	private String token;
	private String hash;
	private String idAccount;
	public Client() {
		
	}
	public Client(String numeroCarte, String hash) {
		this.numeroCarte = numeroCarte;
		this.hash = hash;
		this.token = null;
		this.idAccount = null;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
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
