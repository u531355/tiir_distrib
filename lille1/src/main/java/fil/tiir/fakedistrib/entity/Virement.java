package fil.tiir.fakedistrib.entity;

import java.util.Date;

/**
 * The persistent class for the virement database table.
 * 
 */
public class Virement {
	private Integer idVirement;

	private Date date;

	private Integer ibanFrom;

	private Integer ibanTo;

	private Banque banque;

	private double montant;

	public Virement(Integer ibanFrom, Integer ibanTo, Banque banque, double montant) {
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

	public Integer getIbanFrom() {
		return this.ibanFrom;
	}

	public Integer getIbanTo() {
		return this.ibanTo;
	}

	public Banque getBanque() {
		return this.banque;
	}

	public double getMontant() {
		return this.montant;
	}

}