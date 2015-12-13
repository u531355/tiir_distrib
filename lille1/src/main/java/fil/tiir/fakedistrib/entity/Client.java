package fil.tiir.fakedistrib.entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Object representing the data useful for communicating with the bank
 * 
 * @author blanquart
 *
 */
public class Client {

	public static final int END_ID_BANQUE = 1;

	private String numeroCarte;
	private String token;
	private String hash;
	private String idAccount;
	private boolean connected;
	private Banque bank;
	private int montant;

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

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

	public String getNumeroCarteSansStart() {
		return numeroCarte.substring(END_ID_BANQUE);
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
