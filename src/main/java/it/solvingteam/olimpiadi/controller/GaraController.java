package it.solvingteam.olimpiadi.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.solvingteam.olimpiadi.dto.DisciplinaInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraSearchFilterDTO;
import it.solvingteam.olimpiadi.service.DisciplinaService;
import it.solvingteam.olimpiadi.service.GaraService;

@Controller
@RequestMapping("gara")
public class GaraController {
	
	@Autowired
    private GaraService garaService;
	
	@Autowired
    private DisciplinaService disciplinaService;
	
    @PostMapping("crea")
    public String crea(@Valid @ModelAttribute("garaInsertDTO") GaraInsertDTO garainsertDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
        	List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
    		model.addAttribute("discipline", alldiscipline);
            return "gara/crea";
        } else {
        	garaService.insert(garainsertDTO);
            return "redirect:/gara/";
        }
    }
	
	@GetMapping("crea")
    public String crea(Model model) {
		List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
		model.addAttribute("discipline", alldiscipline);
		model.addAttribute("garaInsertDTO", new GaraInsertDTO());
        return "gara/crea";
    }
	
	@GetMapping("back")
    public String back() {
        return "index";
    }
	
	@GetMapping("home")
    public String home() {
        return "gara/home";
    }
	
    @GetMapping
    public String list(GaraSearchFilterDTO garasearchFilterDTO, Model model) {
        List<GaraInsertDTO> allgare = garaService.findBySearchParameter(garasearchFilterDTO);
        List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
        
        model.addAttribute("searchFilters", garasearchFilterDTO);
        model.addAttribute("discipline", alldiscipline);
        model.addAttribute("stati", Arrays.asList("CREATA", "IN_CALENDARIO", "TERMINATA"));
        
        model.addAttribute("gare", allgare);
        return "gara/cerca";
    }

}
