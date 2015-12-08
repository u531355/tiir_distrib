package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the distributeur database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Distributeur.findAll", query = "SELECT d FROM Distributeur d")
public class Distributeur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_distributeur")
	private Integer idDistributeur;

	private double montant;

	public Distributeur() {

	}

	public Distributeur(double montant) {
		this.montant = montant;
	}

	public Integer getIdDistributeur() {
		return this.idDistributeur;
	}

	public double getMontant() {
		return this.montant;
	}

	public void diminuerMontant(double montant) {
		this.montant -= montant;
	}

}