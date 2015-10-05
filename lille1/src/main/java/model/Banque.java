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
	@Column(name="id_banque")
	private Integer idBanque;

	@Column(name="iban_start")
	private Integer ibanStart;

	private String url;

	public Banque() {
	}

	public Integer getIdBanque() {
		return this.idBanque;
	}

	public void setIdBanque(Integer idBanque) {
		this.idBanque = idBanque;
	}

	public Integer getIbanStart() {
		return this.ibanStart;
	}

	public void setIbanStart(Integer ibanStart) {
		this.ibanStart = ibanStart;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}