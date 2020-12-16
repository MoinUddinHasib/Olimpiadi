package it.solvingteam.olimpiadi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solvingteam.olimpiadi.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	Optional<Disciplina> findByNome(String nome);
	
}
