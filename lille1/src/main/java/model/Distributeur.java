package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the distributeur database table.
 * 
 */
@Entity
@NamedQuery(name="Distributeur.findAll", query="SELECT d FROM Distributeur d")
public class Distributeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_distributeur")
	private Integer idDistributeur;

	private double montant;

	public Distributeur() {
	}

	public Integer getIdDistributeur() {
		return this.idDistributeur;
	}

	public void setIdDistributeur(Integer idDistributeur) {
		this.idDistributeur = idDistributeur;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}