package it.solvingteam.olimpiadi.controller.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.service.AtletaService;

@Component
public class AtletaSignupMessageValidator implements Validator {


    @Autowired
    private AtletaService atletaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AtletaInsertDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	AtletaInsertDTO atletaInsertDTO = (AtletaInsertDTO) o;

        Optional<Atleta> atleta = atletaService.findAtletaByUsername(atletaInsertDTO.getUsername());
        if (atleta.isPresent()) {
            errors.rejectValue("username", "usernameAlreadyExists", "Username already exists");
        }
    }
}
