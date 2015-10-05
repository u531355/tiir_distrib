package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the virement database table.
 * 
 */
@Entity
@NamedQuery(name="Virement.findAll", query="SELECT v FROM Virement v")
public class Virement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_virement")
	private Integer idVirement;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="iban_from")
	private Integer ibanFrom;

	@Column(name="iban_to")
	private Integer ibanTo;

	@Column(name="id_banque")
	private Integer idBanque;

	private double montant;

	public Virement() {
	}

	public Integer getIdVirement() {
		return this.idVirement;
	}

	public void setIdVirement(Integer idVirement) {
		this.idVirement = idVirement;
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

	public Integer getIbanTo() {
		return this.ibanTo;
	}

	public void setIbanTo(Integer ibanTo) {
		this.ibanTo = ibanTo;
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