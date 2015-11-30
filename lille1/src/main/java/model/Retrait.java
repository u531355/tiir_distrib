package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the retrait database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Retrait.findAll", query = "SELECT r FROM Retrait r")
public class Retrait implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_retrait")
	private Integer idRetrait;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "iban_from")
	private Integer ibanFrom;

	@Column(name = "id_banque")
	private Integer idBanque;

	private double montant;

	public Retrait(Integer ibanFrom, Integer idBanque, double montant) {
		this.date = new Date();
		this.ibanFrom = ibanFrom;
		this.idBanque = idBanque;
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

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public double getMontant() {
		return this.montant;
	}

}