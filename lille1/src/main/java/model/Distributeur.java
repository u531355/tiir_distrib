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

	private double solde;

	public Distributeur(double solde) {
		this.solde = solde;
	}

	protected Distributeur() {
	}

	public Integer getIdDistributeur() {
		return this.idDistributeur;
	}

	public double getSolde() {
		return this.solde;
	}

	public void retirer(double montant) {
		// TODO
	}
}