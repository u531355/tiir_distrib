package model;

public class Client {
	private Banque myBank;
	private String iban;
	private String token;

	public Client(String iban, String token) {
		this.iban = iban;
		this.token = token;
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

}