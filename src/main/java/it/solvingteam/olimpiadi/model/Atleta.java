package it.solvingteam.olimpiadi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private Set<Disciplina> discipline;
	
	private Integer punti_totale;
	
	private Integer oro;
	
	private Integer argento;
	
	private Integer bronzo;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "atleta_fk_gara")
	private Gara gara;

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

	public Gara getGara() {
		return gara;
	}

	public void setGara(Gara gara) {
		this.gara = gara;
	}

}
