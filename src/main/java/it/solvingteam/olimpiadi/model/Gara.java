package it.solvingteam.olimpiadi.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Gara {
	
	public enum  Stato {CREATA, IN_CALENDARIO, TERMINATA}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer partecipanti_approvati;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gara_fk_disciplina")
	private Disciplina disciplina;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gara")
	private Set<Atleta> partecipanti;
	
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	private Integer modificatore;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPartecipanti_approvati() {
		return partecipanti_approvati;
	}

	public void setPartecipanti_approvati(Integer partecipanti_approvati) {
		this.partecipanti_approvati = partecipanti_approvati;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Atleta> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(Set<Atleta> partecipanti) {
		this.partecipanti = partecipanti;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Integer getModificatore() {
		return modificatore;
	}

	public void setModificatore(Integer modificatore) {
		this.modificatore = modificatore;
	}

}
