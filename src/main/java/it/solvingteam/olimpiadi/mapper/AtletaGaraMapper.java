package it.solvingteam.olimpiadi.mapper;

import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.AtletaGaraDTO;
import it.solvingteam.olimpiadi.model.AtletaGara;
@Component
public class AtletaGaraMapper extends AbstractMapper<AtletaGara, AtletaGaraDTO> {

	@Override
	public AtletaGaraDTO convertEntityToDto(AtletaGara entity) {
		if (entity == null) {
            return null;
        }
        
        AtletaGaraDTO atletaGaraDTO = new AtletaGaraDTO();
        atletaGaraDTO.setIda(entity.getAtleta().getId().toString());
        atletaGaraDTO.setIdg(entity.getGara().getId().toString());
        atletaGaraDTO.setNome(entity.getAtleta().getNome());
        atletaGaraDTO.setCognome(entity.getAtleta().getCognome());
        atletaGaraDTO.setStato(entity.getStato().toString());
        
        return atletaGaraDTO;
	}

	@Override
	public AtletaGara convertDtoToEntity(AtletaGaraDTO dto) {
        if (dto == null) {
            return null;
        }
        
//        AtletaGara ag = new AtletaGara();
//        if (dto.getId() != null) {
//        	ag.setId(Integer.valueOf(dto.getId()));
//        }
        Util.stampa(this.toString());
        return null;
	}

}
