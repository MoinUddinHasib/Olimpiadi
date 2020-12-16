package it.solvingteam.olimpiadi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.dto.AtletaSearchFilterDTO;
import it.solvingteam.olimpiadi.dto.DisciplinaInsertDTO;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.model.RappresentanteNazione;
import it.solvingteam.olimpiadi.model.Utente;
import it.solvingteam.olimpiadi.repository.RappresentanteNazioneRepository;
import it.solvingteam.olimpiadi.service.AtletaService;
import it.solvingteam.olimpiadi.service.DisciplinaService;

@Controller
@RequestMapping("rappresentanza")
public class GestioneRappresentanzaController {
	
	@Autowired
    private RappresentanteNazioneRepository rappresentanteNazioneRepository;
	
	@Autowired
    private AtletaService atletaService;
	
	@Autowired
    private DisciplinaService disciplinaService;
	
    @PostMapping("creaAtleta")
    public String crea(@Valid @ModelAttribute("atletaInsertDTO") AtletaInsertDTO atletaInsertDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
        	List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
    		model.addAttribute("discipline", alldiscipline);
//    		RappresentanteNazione rn = (RappresentanteNazione) SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get();
//    		adto.setRappresentanteId(rn.getId().toString());
//    		model.addAttribute("atletaInsertDTO", adto); verificare che non mi perda l'id del RappresentanteNazione
            return "rappresentanza/creaAtleta";
        } else {
        	
        	atletaInsertDTO.setRuolo(Utente.Ruolo.ATLETA.toString());
        	atletaInsertDTO.setPunti_totale("0");
        	atletaInsertDTO.setOro("0");
        	atletaInsertDTO.setArgento("0");
        	atletaInsertDTO.setBronzo("0");
        	atletaInsertDTO.setStato(Atleta.Stato.IN_ATTIVITA.toString());
        	atletaService.insert(atletaInsertDTO);
            return "redirect:/rappresentanza/";
        }
    }
	
	@GetMapping("creaAtleta")
    public String crea(Model model) {
		List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
		model.addAttribute("discipline", alldiscipline);
		AtletaInsertDTO adto = new AtletaInsertDTO();
		RappresentanteNazione rn = (RappresentanteNazione) SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get();
		adto.setRappresentanteId(rn.getId().toString());
		model.addAttribute("atletaInsertDTO", adto);
        return "rappresentanza/crea_atleta";
    }
	
	@GetMapping("back")
    public String back() {
        return "index";
    }
	
	@GetMapping("home")
    public String home() {
        return "rappresentanza/home";
    }
	
    @GetMapping
    public String listAtleti(AtletaSearchFilterDTO atletasearchFilterDTO, Model model) {
        List<AtletaInsertDTO> allatleti = atletaService.findBySearchParameter(atletasearchFilterDTO);
        List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
        
        model.addAttribute("searchFilters", atletasearchFilterDTO);
        model.addAttribute("discipline", alldiscipline);
        
        model.addAttribute("gare", allatleti);
        return "rappresentanza/cerca";
    }

}
