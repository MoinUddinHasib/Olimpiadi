package it.solvingteam.olimpiadi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RappresentanteNazione extends Utente {
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rappresentante_fk_nazione", referencedColumnName = "id")
	private Nazione nazione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rappresentante")
	private Set<Atleta> atleti = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rappresentante_fk_organizzatore")
	private Utente organizzatore;

	public Nazione getNazione() {
		return nazione;
	}

	public void setNazione(Nazione nazione) {
		this.nazione = nazione;
	}

	public Set<Atleta> getAtleti() {
		return atleti;
	}

	public void setAtleti(Set<Atleta> atleti) {
		this.atleti = atleti;
	}

	public Utente getOrganizzatore() {
		return organizzatore;
	}

	public void setOrganizzatore(Utente organizzatore) {
		this.organizzatore = organizzatore;
	}

}
