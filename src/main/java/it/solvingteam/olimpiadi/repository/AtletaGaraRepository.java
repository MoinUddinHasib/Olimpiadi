package it.solvingteam.olimpiadi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.solvingteam.olimpiadi.model.AtletaGara;

public interface AtletaGaraRepository extends JpaRepository<AtletaGara, Integer> {

	@Query("FROM AtletaGara ag WHERE ag.gara.id = ?1")
	List<AtletaGara> findAllAtletaGaraByGaraId(Integer id);
	
	@Query("FROM AtletaGara ag WHERE ag.atleta.id = ?1 and ag.gara.id = ?2")
	AtletaGara findWithIdaIdg(Integer ida, Integer idg);

	@Query("FROM AtletaGara ag WHERE ag.gara.id = ?1 and ag.stato = 'APPROVATO'")
	List<AtletaGara> findAllAtletiGaraApprovatiByGaraId(Integer id);
}
