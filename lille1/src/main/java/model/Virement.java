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
 * The persistent class for the virement database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Virement.findAll", query = "SELECT v FROM Virement v")
public class Virement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_virement")
	private Integer idVirement;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "iban_from")
	private Integer ibanFrom;

	@Column(name = "iban_to")
	private Integer ibanTo;

	@Column(name = "id_banque")
	private Integer idBanque;

	private double montant;

	public Virement(Integer ibanFrom, Integer ibanTo, Integer idBanque, double montant) {
		this.date = new Date();
		this.ibanFrom = ibanFrom;
		this.ibanTo = ibanTo;
		this.idBanque = idBanque;
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

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public double getMontant() {
		return this.montant;
	}

}