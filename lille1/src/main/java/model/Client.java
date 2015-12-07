package model;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * Object representing the data useful for communicate with the bank
 * @author blanquart
 *
 */
public class Client {
	
	private String numeroCarte;
	private String token;
	private String hash;
	private String idAccount;
	private boolean connected;
	private Banque bank;
	public Client() {

	}

	@Autowired
	public Client(String numeroCarte, String hash) {
		this.numeroCarte = numeroCarte;
		this.hash = hash;
		this.token = null;
		this.idAccount = null;
		this.connected = false;
	}
	public Banque getBank() {
		return bank;
	}
	public void setBank(Banque bank) {
		this.bank = bank;
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
}
