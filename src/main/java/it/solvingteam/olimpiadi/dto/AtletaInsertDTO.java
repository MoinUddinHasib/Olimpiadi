package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.NotEmpty;

public class AtletaInsertDTO extends UtenteInsertDTO {
	
	private String rappresentanteId;
	
	@NotEmpty(message = "Selezionare almeno la prima disciplina")
	private String disciplinaId1;
	
	private String disciplinaId2;
	
	private String disciplinaId3;
	
	private String punti_totale;
	
	private String oro;
	
	private String argento;
	
	private String bronzo;
	
	private String stato;

	public String getRappresentanteId() {
		return rappresentanteId;
	}

	public void setRappresentanteId(String rappresentanteId) {
		this.rappresentanteId = rappresentanteId;
	}

	public String getDisciplinaId1() {
		return disciplinaId1;
	}

	public void setDisciplinaId1(String disciplinaId1) {
		this.disciplinaId1 = disciplinaId1;
	}

	public String getDisciplinaId2() {
		return disciplinaId2;
	}

	public void setDisciplinaId2(String disciplinaId2) {
		this.disciplinaId2 = disciplinaId2;
	}

	public String getDisciplinaId3() {
		return disciplinaId3;
	}

	public void setDisciplinaId3(String disciplinaId3) {
		this.disciplinaId3 = disciplinaId3;
	}

	public String getPunti_totale() {
		return punti_totale;
	}

	public void setPunti_totale(String punti_totale) {
		this.punti_totale = punti_totale;
	}

	public String getOro() {
		return oro;
	}

	public void setOro(String oro) {
		this.oro = oro;
	}

	public String getArgento() {
		return argento;
	}

	public void setArgento(String argento) {
		this.argento = argento;
	}

	public String getBronzo() {
		return bronzo;
	}

	public void setBronzo(String bronzo) {
		this.bronzo = bronzo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}
