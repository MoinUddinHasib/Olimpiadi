package it.solvingteam.olimpiadi.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.dto.AtletaSearchFilterDTO;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.model.Disciplina;
import it.solvingteam.olimpiadi.service.AtletaService;
import it.solvingteam.olimpiadi.service.GaraService;

@Controller
@RequestMapping("carriera")
public class GestioneCarrieraController {
	
	@Autowired
    private AtletaService atletaService;
	
	@Autowired
    private GaraService garaService;
	
	@GetMapping("medagliere")
    public String medagliere(Model model) {
		Atleta a = (Atleta) SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get();
		AtletaInsertDTO atleta= atletaService.getById(a.getId());
		model.addAttribute("atleta",atleta);
        return "carriera/show";
    }
	
	@GetMapping("ritirati")
    public String ritirati(Model model) {
		Atleta a = (Atleta) SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get();
		AtletaInsertDTO aDTO = atletaService.getById(a.getId());
		aDTO.setStato(Atleta.Stato.RITIRATO.toString());
		atletaService.update(aDTO);
		return "redirect:/carriera/home";
    }
	
	@GetMapping("back")
    public String back() {
        return "index";
    }
	
	@GetMapping("home")
    public String home() {
        return "carriera/home";
    }
	
    @GetMapping
    public String listAtletiGare(AtletaSearchFilterDTO atletasearchFilterDTO, Model model) {
    	Atleta a = (Atleta) SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get();
    	
    	Disciplina d1Id= null;
    	Disciplina d2Id= null;
    	Disciplina d3Id= null;
    	Iterator<Disciplina> i =a.getDiscipline().iterator();
    	switch(a.getDiscipline().size()) {
    		case 3: d3Id = i.next();
    		case 2: d2Id = i.next();
    		case 1: d1Id = i.next();
    	}
    	
        List<GaraInsertDTO> allgare = garaService.findByIdAtletaAndDiscipline(d1Id.getId(),d2Id.getId(),d3Id.getId());
        
        model.addAttribute("gare", allgare);
        return "carriera/lista";
    }

}
