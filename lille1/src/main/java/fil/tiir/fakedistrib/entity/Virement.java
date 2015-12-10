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

	public Virement(String ibanFrom, String ibanTo, Banque banque, int montant) {
		this.date = new Date();
		this.ibanFrom = ibanFrom;
		this.ibanTo = ibanTo;
		this.banque = banque;
		this.montant = montant;
	}

	protected Virement() {
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

}