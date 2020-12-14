package it.solvingteam.olimpiadi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    private Set<Atleta> atleti =new HashSet<>();

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

	public Set<Atleta> getAtleti() {
		return atleti;
	}

	public void setAtleti(Set<Atleta> atleti) {
		this.atleti = atleti;
	}
    
}
