package it.solvingteam.olimpiadi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Atleta extends Utente {

	public enum Stato {IN_ATTIVITA, RITIRATO}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atleta_fk_rappresentante")
	private RappresentanteNazione rappresentante;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "atleta_disciplina",
	joinColumns = @JoinColumn(name = "atleta_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"))
	private Set<Disciplina> discipline = new HashSet<>();
	
	private Integer punti_totale;
	
	private Integer oro;
	
	private Integer argento;
	
	private Integer bronzo;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
	private Set<AtletaGara> gare = new HashSet<>();

	public RappresentanteNazione getRappresentante() {
		return rappresentante;
	}

	public void setRappresentante(RappresentanteNazione rappresentante) {
		this.rappresentante = rappresentante;
	}

	public Set<Disciplina> getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Set<Disciplina> discipline) {
		this.discipline = discipline;
	}

	public Integer getPunti_totale() {
		return punti_totale;
	}

	public void setPunti_totale(Integer punti_totale) {
		this.punti_totale = punti_totale;
	}

	public Integer getOro() {
		return oro;
	}

	public void setOro(Integer oro) {
		this.oro = oro;
	}

	public Integer getArgento() {
		return argento;
	}

	public void setArgento(Integer argento) {
		this.argento = argento;
	}

	public Integer getBronzo() {
		return bronzo;
	}

	public void setBronzo(Integer bronzo) {
		this.bronzo = bronzo;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Set<AtletaGara> getGare() {
		return gare;
	}

	public void setGare(Set<AtletaGara> gare) {
		this.gare = gare;
	}


}
