package it.solvingteam.olimpiadi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class AtletaGara {
	
	@EmbeddedId
    private AtletaGaraId id = new AtletaGaraId();
	
	
//	@JoinColumn(name = "id_atleta")
	@ManyToOne
	@MapsId("idAtleta")
	private Atleta atleta;
	
	
//	@JoinColumn(name = "id_gara")
	@ManyToOne
	@MapsId("idGara")
	private Gara gara;
	
	private Integer posizione;

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

	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}


	

}
