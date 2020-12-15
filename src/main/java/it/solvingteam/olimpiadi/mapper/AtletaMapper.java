package it.solvingteam.olimpiadi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.model.Disciplina;

@Component
public class AtletaMapper extends AbstractMapper<Atleta, AtletaInsertDTO> {
    @Override
    public AtletaInsertDTO convertEntityToDto(Atleta entity) {
        if (entity == null) {
            return null;
        }
        
        AtletaInsertDTO atletaDTO = new AtletaInsertDTO();
        
        atletaDTO.setId(entity.getId().toString());
        atletaDTO.setNome(entity.getNome());
        atletaDTO.setCognome(entity.getCognome());
        atletaDTO.setCf(entity.getCf());
        atletaDTO.setUsername(entity.getUsername());
        atletaDTO.setPassword(entity.getPassword());
        atletaDTO.setRuolo(entity.getRuolo().toString());
        atletaDTO.setRappresentante(entity.getRappresentante().getUsername());
        
        List<Disciplina> discipline=new ArrayList<>(entity.getDiscipline());
        int size= discipline.size();
        switch(size) {
        case 3:
        	atletaDTO.setDisciplinaId3(discipline.get(2).getNome());
        case 2:
        	atletaDTO.setDisciplinaId2(discipline.get(1).getNome());
        case 1:
        	atletaDTO.setDisciplinaId1(discipline.get(0).getNome());
        }
        
        atletaDTO.setPunti_totale(entity.getPunti_totale().toString());
        atletaDTO.setOro(entity.getOro().toString());
        atletaDTO.setArgento(entity.getArgento().toString());
        atletaDTO.setBronzo(entity.getBronzo().toString());
        atletaDTO.setStato(entity.getStato().toString());

        return atletaDTO;
    }

    @Override
    public Atleta convertDtoToEntity(AtletaInsertDTO dto) {
        if (dto == null) {
            return null;
        }

//        Customer customer = new Customer();
//
//        if (dto.getId() != null) {
//            customer.setId(Integer.valueOf(dto.getId()));
//        }
//
//        customer.setName(dto.getName());
//        customer.setAddress(dto.getAddress());
//        customer.setMobile(dto.getMobile());
//
        Util.stampa(this.toString());
        return null;
    }
}
