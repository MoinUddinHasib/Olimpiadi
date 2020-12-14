package it.solvingteam.olimpiadi.dto;

public class GaraSearchFilterDTO {
	
	private String numero_partecipanti;
	
	private String disciplinaId;
    
	private String data;
    
	private String stato;
    
	private String modificatore;

	public String getPartecipanti_approvati() {
		return numero_partecipanti;
	}

	public void setPartecipanti_approvati(String numero_partecipanti) {
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
