package fil.tiir.fakedistrib.entity;

import java.util.Date;

/**
 * The persistent class for the retrait database table.
 * 
 */
public class Retrait {

	private Integer idRetrait;

	private Date date;

	private Integer ibanFrom;

	private Banque banque;

	private double montant;

	public Retrait(Integer ibanFrom, Banque banque, double montant) {
		this.date = new Date();
		this.ibanFrom = ibanFrom;
		this.banque = banque;
		this.montant = montant;
	}

	protected Retrait() {
	}

	public Integer getIdRetrait() {
		return this.idRetrait;
	}

	public Date getDate() {
		return this.date;
	}

	public Integer getIbanFrom() {
		return this.ibanFrom;
	}

	public Banque getBanque() {
		return this.banque;
	}

	public double getMontant() {
		return this.montant;
	}

}