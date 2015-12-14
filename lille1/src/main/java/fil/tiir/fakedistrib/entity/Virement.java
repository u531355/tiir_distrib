package fil.tiir.fakedistrib.entity;

import java.util.Date;

/**
 * The persistent class for the virement database table.
 * 
 */
public class Virement {

	private Integer idVirement;

	private Date date;

	private String ibanFrom;

	private String ibanTo;

	private Banque banque;

	private int montant;

	public Virement(Client client) {
		this.banque = client.getBank();
		this.ibanFrom = client.getIdAccount();
		this.date = new Date();
	}

	public Integer getIdVirement() {
		return this.idVirement;
	}

	public Date getDate() {
		return this.date;
	}

	public String getIbanFrom() {
		return this.ibanFrom;
	}

	public String getIbanTo() {
		return this.ibanTo;
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

	public void setIbanTo(String ibanTo) {
		this.ibanTo = ibanTo;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

}