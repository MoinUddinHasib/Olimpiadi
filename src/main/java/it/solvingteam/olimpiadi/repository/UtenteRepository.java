package it.solvingteam.olimpiadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.olimpiadi.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
