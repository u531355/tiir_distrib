package fil.tiir.fakedistrib.entity;

/**
 * The persistent class for the distributeur database table.
 * 
 */
public class Distributeur {

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