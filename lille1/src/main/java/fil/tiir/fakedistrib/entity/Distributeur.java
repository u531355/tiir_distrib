package fil.tiir.fakedistrib.entity;

/**
 * The persistent class for the distributeur database table.
 * 
 */
public class Distributeur {

	private Integer idDistributeur;

	private int montant;

	public Distributeur() {

	}

	public Distributeur(int montant) {
		this.montant = montant;
	}

	public Integer getIdDistributeur() {
		return this.idDistributeur;
	}

	public int getMontant() {
		return this.montant;
	}

	public void diminuerMontant(int montant) {
		this.montant -= montant;
	}

}