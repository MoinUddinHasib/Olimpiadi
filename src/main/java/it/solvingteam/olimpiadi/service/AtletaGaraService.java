package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.dto.AtletaGaraDTO;
import it.solvingteam.olimpiadi.mapper.AtletaGaraMapper;
import it.solvingteam.olimpiadi.model.AtletaGara;
import it.solvingteam.olimpiadi.model.AtletaGaraId;
import it.solvingteam.olimpiadi.repository.AtletaGaraRepository;
import it.solvingteam.olimpiadi.repository.AtletaRepository;
import it.solvingteam.olimpiadi.repository.GaraRepository;

@Service
public class AtletaGaraService {
	
	@Autowired
    private AtletaGaraRepository atletaGaraRepository;
	
	@Autowired
    private AtletaRepository atletaRepository;
	
	@Autowired
    private GaraRepository garaRepository;
	
	@Autowired
    private AtletaGaraMapper atletaGaraMapper;
	
	public List<AtletaGaraDTO> findAtletaGaraByGaraId(Integer id) {
		List<AtletaGara> Atletig = this.atletaGaraRepository.findAllAtletaGaraByGaraId(id);
		return atletaGaraMapper.convertEntityToDto(Atletig);
	}
	
	public AtletaGaraDTO getByDoubleId(Integer ida, Integer idg) {
		return atletaGaraMapper.convertEntityToDto(this.atletaGaraRepository.findWithIdaIdg(ida,idg));
	}
	
    public AtletaGara update(AtletaGaraDTO atletaGaraDTO) {
    	String ida= atletaGaraDTO.getIda();    	
    	String idg= atletaGaraDTO.getIdg();    	  	
    	String stato = atletaGaraDTO.getStato();
    	String posizione_in_classifica = atletaGaraDTO.getPosizione_in_classifica();

    	AtletaGaraId id = new AtletaGaraId(Integer.parseInt(ida),Integer.parseInt(idg));
    	AtletaGara ag = new AtletaGara();
    	ag.setId(id);
    	ag.setAtleta(atletaRepository.findById(Integer.parseInt(ida)).orElse(null));
    	ag.setGara(garaRepository.findById(Integer.parseInt(idg)).orElse(null));
    	if(posizione_in_classifica!=null && !posizione_in_classifica.isEmpty()) {
        	ag.setPosizione_in_classifica(Integer.parseInt(posizione_in_classifica));
    	}
    	ag.setStato(AtletaGara.Stato.valueOf(stato));

        return this.atletaGaraRepository.save(ag);
    }

    public void delete(Integer idg) {
    	List<AtletaGara> ag=atletaGaraRepository.findAllAtletaGaraByGaraId(idg);
    	for(AtletaGara atletaIscritto: ag) {
    		this.atletaGaraRepository.delete(atletaIscritto);
    	}
        this.garaRepository.delete(garaRepository.findById(idg).orElse(null));
    }
    
	public List<AtletaGaraDTO> findAtletaGaraAutorizzatiByGaraId(Integer id) {
		List<AtletaGara> Atletig = this.atletaGaraRepository.findAllAtletiGaraApprovatiByGaraId(id);
		return atletaGaraMapper.convertEntityToDto(Atletig);
	}

}
