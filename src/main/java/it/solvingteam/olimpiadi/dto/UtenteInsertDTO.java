package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.NotEmpty;

public class UtenteInsertDTO {
	
    private String id;
    
    @NotEmpty(message = "Required field")	
	private String nome;
	
    @NotEmpty(message = "Required field")
	private String cognome;
	
    @NotEmpty(message = "Required field")
	private String cf;
	
    @NotEmpty(message = "Required field")
	private String username;
	
    @NotEmpty(message = "Required field")
	private String password;
	
	private String ruolo;


	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
