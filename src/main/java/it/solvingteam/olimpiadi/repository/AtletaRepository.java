package it.solvingteam.olimpiadi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.olimpiadi.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
	
    Optional<Atleta> findByUsername(String username);

}
