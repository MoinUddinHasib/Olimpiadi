package it.solvingteam.olimpiadi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AtletaGaraId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idAtleta;
	
	private Integer idGara;

	public AtletaGaraId() {
		super();
	}

	public AtletaGaraId(Integer idAtleta, Integer idGara) {
		super();
		this.idAtleta = idAtleta;
		this.idGara = idGara;
	}

	public Integer getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(Integer idAtleta) {
		this.idAtleta = idAtleta;
	}

	public Integer getIdGara() {
		return idGara;
	}

	public void setIdGara(Integer idGara) {
		this.idGara = idGara;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAtleta == null) ? 0 : idAtleta.hashCode());
		result = prime * result + ((idGara == null) ? 0 : idGara.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtletaGaraId other = (AtletaGaraId) obj;
		if (idAtleta == null) {
			if (other.idAtleta != null)
				return false;
		} else if (!idAtleta.equals(other.idAtleta))
			return false;
		if (idGara == null) {
			if (other.idGara != null)
				return false;
		} else if (!idGara.equals(other.idGara))
			return false;
		return true;
	}
	

}
