package fil.tiir.fakedistrib.entity;

import java.util.Date;

/**
 * The persistent class for the retrait database table.
 * 
 */
public class Retrait {

	private Integer idRetrait;

	private Date date;

	private String ibanFrom;

	private Banque banque;

	private int montant;

	public void update(Client client) {
		this.date = new Date();
		this.banque = client.getBank();
		this.ibanFrom = client.getNumeroCarte();
	}

	public Retrait() {

	}

	public Integer getIdRetrait() {
		return this.idRetrait;
	}

	public Date getDate() {
		return this.date;
	}

	public String getIbanFrom() {
		return this.ibanFrom;
	}

	public Banque getBanque() {
		return this.banque;
	}

	public int getMontant() {
		return this.montant;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setIbanFrom(String ibanFrom) {
		this.ibanFrom = ibanFrom;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

}