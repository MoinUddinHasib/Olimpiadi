package it.solvingteam.olimpiadi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utente {
	
	public enum  Ruolo {ORGANIZZATORE, ATLETA, RAPPRESENTANTE_NAZIONE}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String cognome;
	
	private String cf;
	
	private String username;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizzatore")
	private Set<RappresentanteNazione> rappresentanti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public Set<RappresentanteNazione> getRappresentanti() {
		return rappresentanti;
	}

	public void setRappresentanti(Set<RappresentanteNazione> rappresentanti) {
		this.rappresentanti = rappresentanti;
	}
	
}

