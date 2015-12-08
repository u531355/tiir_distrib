package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the banque database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Banque.findAll", query = "SELECT b FROM Banque b")
public class Banque implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_banque")
	private Integer idBanque;

	@Column(name = "card_start")
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

	public String getCardStart() {
		return this.cardStart;
	}

	public String getUrl() {
		return this.url;
	}

}