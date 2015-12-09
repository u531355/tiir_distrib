package fil.tiir.fakedistrib.entity;

/**
 * The persistent class for the banque database table.
 * 
 */
public class Banque {

	private Integer idBanque;

	private String cardStart;

	private String url;

	public Banque() {
	}

	public Banque(String cardStart, String url) {
		this.cardStart = cardStart;
		this.url = url;
	}

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public String getCardStart() {
		return this.cardStart;
	}

	public String getUrl() {
		return this.url;
	}

}