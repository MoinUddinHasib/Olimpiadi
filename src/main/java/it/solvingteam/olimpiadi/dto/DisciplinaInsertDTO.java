package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.NotEmpty;

public class DisciplinaInsertDTO {
	
	private String id;
    
    @NotEmpty(message = "Required field")
    private String nome;

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

}
