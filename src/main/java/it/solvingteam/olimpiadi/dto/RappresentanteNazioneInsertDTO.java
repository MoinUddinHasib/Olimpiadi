package it.solvingteam.olimpiadi.dto;

import javax.validation.constraints.NotEmpty;

public class RappresentanteNazioneInsertDTO extends UtenteInsertDTO{
	
	@NotEmpty(message = "Required field")
	private String nazioneId;
	
	private String organizzatore;

	public String getNazioneId() {
		return nazioneId;
	}

	public void setNazioneId(String nazioneId) {
		this.nazioneId = nazioneId;
	}

	public String getOrganizzatore() {
		return organizzatore;
	}

	public void setOrganizzatore(String organizzatore) {
		this.organizzatore = organizzatore;
	}

}
