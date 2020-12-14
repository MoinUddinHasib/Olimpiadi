package it.solvingteam.olimpiadi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.olimpiadi.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	Optional<Utente> findByUsername(String username);

}
