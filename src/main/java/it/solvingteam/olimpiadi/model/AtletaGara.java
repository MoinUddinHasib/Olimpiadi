package it.solvingteam.olimpiadi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class AtletaGara {
	
	public enum Stato {APPROVATO, DISAPPROVATO, IN_VALUTAZIONE}
	
	@EmbeddedId
    private AtletaGaraId id = new AtletaGaraId();
	
	@ManyToOne
	@MapsId("idAtleta")
	private Atleta atleta;
	
	@ManyToOne
	@MapsId("idGara")
	private Gara gara;
	
	private Integer posizione_in_classifica;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	public AtletaGaraId getId() {
		return id;
	}

	public void setId(AtletaGaraId id) {
		this.id = id;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Gara getGara() {
		return gara;
	}

	public void setGara(Gara gara) {
		this.gara = gara;
	}

	public Integer getPosizione_in_classifica() {
		return posizione_in_classifica;
	}

	public void setPosizione_in_classifica(Integer posizione_in_classifica) {
		this.posizione_in_classifica = posizione_in_classifica;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}
	

}
