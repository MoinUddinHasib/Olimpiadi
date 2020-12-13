package it.solvingteam.olimpiadi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Nazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    
    @OneToOne(mappedBy = "nazione")
    private RappresentanteNazione rappresentante;

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

	public RappresentanteNazione getRappresentante() {
		return rappresentante;
	}

	public void setRappresentante(RappresentanteNazione rappresentante) {
		this.rappresentante = rappresentante;
	}
    
}
