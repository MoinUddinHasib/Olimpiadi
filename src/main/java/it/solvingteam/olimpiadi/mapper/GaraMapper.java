package it.solvingteam.olimpiadi.mapper;

import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.model.Gara;

@Component
public class GaraMapper extends AbstractMapper<Gara, GaraInsertDTO> {
    @Override
    public GaraInsertDTO convertEntityToDto(Gara entity) {
        if (entity == null) {
            return null;
        }
        
        GaraInsertDTO garaDTO = new GaraInsertDTO();
        garaDTO.setId(String.valueOf(entity.getId()));
        garaDTO.setNumero_partecipanti(entity.getNumero_partecipanti());
        garaDTO.setDisciplinaId(entity.getDisciplina().getNome().toString());
        garaDTO.setData(entity.getData().toString());
        garaDTO.setStato(entity.getStato().toString());
        garaDTO.setModificatore(entity.getModificatore().toString());

        return garaDTO;
    }

    @Override
    public Gara convertDtoToEntity(GaraInsertDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Gara gara = new Gara();
        if (dto.getId() != null) {
        	gara.setId(Integer.valueOf(dto.getId()));
        }
        
//        gara.setNumero_partecipanti(dto.getNumero_partecipanti());
//        gara.setDisciplina(dto.getDisciplinaId());
//        ...

        Util.stampa(this.toString());
        return null;
    }
}
