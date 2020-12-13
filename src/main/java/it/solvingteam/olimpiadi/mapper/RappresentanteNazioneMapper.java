package it.solvingteam.olimpiadi.mapper;

import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.RappresentanteNazioneInsertDTO;
import it.solvingteam.olimpiadi.model.RappresentanteNazione;

@Component
public class RappresentanteNazioneMapper extends AbstractMapper<RappresentanteNazione, RappresentanteNazioneInsertDTO> {
    @Override
    public RappresentanteNazioneInsertDTO convertEntityToDto(RappresentanteNazione entity) {
        if (entity == null) {
            return null;
        }

//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setId(String.valueOf(entity.getId()));
//        customerDto.setName(entity.getName());
//        customerDto.setAddress(entity.getAddress());
//        customerDto.setMobile(entity.getMobile());
//        customerDto.setSize(String.valueOf(entity.getDeliveries().size()));
//        
        Util.stampa(this.toString());
        return null;
    }

    @Override
    public RappresentanteNazione convertDtoToEntity(RappresentanteNazioneInsertDTO dto) {
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
