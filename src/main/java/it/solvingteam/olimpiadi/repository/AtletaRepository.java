package it.solvingteam.olimpiadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.olimpiadi.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

}
