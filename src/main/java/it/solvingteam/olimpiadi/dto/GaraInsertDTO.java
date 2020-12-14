package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class GaraInsertDTO {
	
	private String id;
	
	private String partecipanti_approvati;
	
	@Min(value = 4, message = "Minimo quattro partecipanti")
    @Max(value = 8, message = "Massimo otto partecipanti")
	private Integer numero_partecipanti;
	
	@NotEmpty(message = "Required field")
	private String disciplinaId;
		
	private String data;
		
	private String stato;
	
	@NotEmpty(message = "Required field")
	private String modificatore;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPartecipanti_approvati() {
		return partecipanti_approvati;
	}

	public void setPartecipanti_approvati(String partecipanti_approvati) {
		this.partecipanti_approvati = partecipanti_approvati;
	}

	public Integer getNumero_partecipanti() {
		return numero_partecipanti;
	}

	public void setNumero_partecipanti(Integer numero_partecipanti) {
		this.numero_partecipanti = numero_partecipanti;
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
