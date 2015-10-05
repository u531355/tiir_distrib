package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the retrait database table.
 * 
 */
@Entity
@NamedQuery(name="Retrait.findAll", query="SELECT r FROM Retrait r")
public class Retrait implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_retrait")
	private Integer idRetrait;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="iban_from")
	private Integer ibanFrom;

	@Column(name="id_banque")
	private Integer idBanque;

	private double montant;

	public Retrait() {
	}

	public Integer getIdRetrait() {
		return this.idRetrait;
	}

	public void setIdRetrait(Integer idRetrait) {
		this.idRetrait = idRetrait;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIbanFrom() {
		return this.ibanFrom;
	}

	public void setIbanFrom(Integer ibanFrom) {
		this.ibanFrom = ibanFrom;
	}

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public void setIdBanque(Integer idBanque) {
		this.idBanque = idBanque;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}