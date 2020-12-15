package it.solvingteam.olimpiadi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.model.AtletaGara;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
	
	@Query("FROM AtletaGara ag WHERE ag.gara.id = ?1")
	List<AtletaGara> findAllAtletaGaraByGaraId(Integer id);

}
