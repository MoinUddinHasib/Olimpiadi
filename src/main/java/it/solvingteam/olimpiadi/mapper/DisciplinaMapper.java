package it.solvingteam.olimpiadi.mapper;

import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.dto.DisciplinaInsertDTO;
import it.solvingteam.olimpiadi.model.Disciplina;

@Component
public class DisciplinaMapper extends AbstractMapper<Disciplina, DisciplinaInsertDTO> {
    @Override
    public DisciplinaInsertDTO convertEntityToDto(Disciplina entity) {
        if (entity == null) {
            return null;
        }
        
        DisciplinaInsertDTO disciplinaDTO = new DisciplinaInsertDTO();
        disciplinaDTO.setId(entity.getId().toString());
        disciplinaDTO.setNome(entity.getNome());

        return disciplinaDTO;
    }

    @Override
    public Disciplina convertDtoToEntity(DisciplinaInsertDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Disciplina disciplina = new Disciplina();
        
        if (dto.getId() != null) {
        	disciplina.setId(Integer.valueOf(dto.getId()));
        }
        
        disciplina.setNome(dto.getNome());

        return disciplina;
    }
}
