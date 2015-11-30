package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the banque database table.
 * 
 */
@Entity
@NamedQuery(name="Banque.findAll", query="SELECT b FROM Banque b")
public class Banque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_banque") 
	private Integer idBanque;

	@Column(name="iban_start")
	private String cardStart;

	private String url;

	public Banque() {
	}
	public Banque(String ibanStart, String url) {
		this.cardStart = ibanStart;
		this.url = url;
	}

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public void setIdBanque(Integer idBanque) {
		this.idBanque = idBanque;
	}

	public String getIbanStart() {
		return this.cardStart;
	}

	public void setIbanStart(String ibanStart) {
		this.cardStart = ibanStart;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}