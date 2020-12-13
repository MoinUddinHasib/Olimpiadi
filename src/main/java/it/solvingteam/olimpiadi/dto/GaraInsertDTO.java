package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.NotEmpty;

public class GaraInsertDTO {
	
	private Integer id;
	
	private Integer partecipanti_approvati;
	
	@NotEmpty(message = "Required field")
	private String disciplinaId;
		
	private String data;
		
	private String stato;
	
	@NotEmpty(message = "Required field")
	private String modificatore;

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

	public String getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(String disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getModificatore() {
		return modificatore;
	}

	public void setModificatore(String modificatore) {
		this.modificatore = modificatore;
	}

}
