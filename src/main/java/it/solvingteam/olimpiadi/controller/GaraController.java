package it.solvingteam.olimpiadi.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.solvingteam.olimpiadi.dto.AtletaGaraDTO;
import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.dto.DisciplinaInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraSearchFilterDTO;
import it.solvingteam.olimpiadi.model.AtletaGara;
import it.solvingteam.olimpiadi.model.Gara;
import it.solvingteam.olimpiadi.service.AtletaGaraService;
import it.solvingteam.olimpiadi.service.AtletaService;
import it.solvingteam.olimpiadi.service.DisciplinaService;
import it.solvingteam.olimpiadi.service.GaraService;

@Controller
@RequestMapping("gara")
public class GaraController {
	
	@Autowired
    private GaraService garaService;
	
	@Autowired
    private AtletaService atletaService;
	
	@Autowired
    private AtletaGaraService atletaGaraService;
		
	@Autowired
    private DisciplinaService disciplinaService;
	
    @GetMapping("avvia/{idg}")
    public String avvia(@PathVariable("idg") Integer idg, Model model, RedirectAttributes redirAttrs) {
    	GaraInsertDTO garaDTO = garaService.getById(idg);
    	List<AtletaGaraDTO> atletig= atletaGaraService.findAtletaGaraAutorizzatiByGaraId(idg);
    	Collections.shuffle(atletig, new Random(System.currentTimeMillis()));
    	
    	if(garaDTO.getStato().equals(Gara.Stato.TERMINATA.toString()) || 
    			garaDTO.getStato().equals(Gara.Stato.CREATA.toString()) ) {
    		return "redirect:/gara/";
    	}
    	
    	if( atletig.size() != garaDTO.getNumero_partecipanti()) {
    		redirAttrs.addFlashAttribute("errorMessage", "Atleti approvati diverso dal numero dei partecipanti");
    		return "redirect:/gara/";
    	}
    	
    	for(int i=0;i<atletig.size();i++) {
    		atletig.get(i).setPosizione_in_classifica(String.valueOf(i+1));
    		atletaGaraService.update(atletig.get(i));
    	}
    	
    	for(int i=0;i<atletig.size();i++) {
    		int pos=Integer.parseInt(atletig.get(i).getPosizione_in_classifica());
    		int mod=Integer.parseInt(garaService.getById(Integer.parseInt(atletig.get(i).getIdg())).getModificatore());
    		int punti=(1+atletig.size()*pos)*mod;
    		AtletaInsertDTO a=atletaService.getById(Integer.parseInt(atletig.get(i).getIda()));
    		a.setPunti_totale(a.getPunti_totale()+punti);
    		switch(pos) {
    			case 1: a.setOro(a.getOro()+1); break;
    			case 2: a.setArgento(a.getArgento()+1); break;
    			case 3: a.setBronzo(a.getBronzo()+1); break;
    		}
    		atletaService.update(a);//TODO
    	}
    	
    	
    	garaDTO.setDisciplinaId(disciplinaService.getByName(garaDTO.getDisciplinaId()).getId());
    	garaDTO.setStato(Gara.Stato.TERMINATA.toString());
    	garaService.update(garaDTO);
    	
    	return "redirect:/gara/show/"+idg;
    }
	
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
    	GaraInsertDTO garaDTO = garaService.getById(id);
    	if(garaDTO.getStato().equals(Gara.Stato.TERMINATA.toString()) ) {
    		return "redirect:/gara/";
    	}
    	
        model.addAttribute("GaraInsertDTO",garaDTO);
        return "gara/delete";
    }
    
    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer idg){
    	atletaGaraService.delete(idg);
        return "redirect:/gara/";
    }
	
    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
    	GaraInsertDTO garaDTO = garaService.getById(id);
    	if(garaDTO.getStato().equals(Gara.Stato.TERMINATA.toString()) ) {
    		return "redirect:/gara/";
    	}
    	
    	garaDTO.setDisciplinaId(disciplinaService.getByName(garaDTO.getDisciplinaId()).getId());
        model.addAttribute("garaUpdate",garaDTO);
        return "gara/update";
    }
    
    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("garaUpdate") GaraInsertDTO garaDTO, BindingResult bindingResult, @PathVariable("id") Integer id, Model model){
        if (bindingResult.hasErrors()) {
        	model.addAttribute("garaUpdate",garaDTO);
            return "gara/update";
        } else {
        	garaDTO.setId(id.toString());
        	if(garaDTO.getData().isEmpty()) {
        		garaDTO.setStato(Gara.Stato.CREATA.toString());
        	} else {
        		garaDTO.setStato(Gara.Stato.IN_CALENDARIO.toString());
        	}
        	garaService.update(garaDTO);
            return "redirect:/gara/";
        }
    }
	
    @GetMapping("autorizza/{ida}/{idg}")
    public String autorizza(@PathVariable("ida") Integer ida, @PathVariable("idg") Integer idg, Model model) {
    	AtletaGaraDTO agDTO= atletaGaraService.getByDoubleId(ida, idg);
    	agDTO.setStato(AtletaGara.Stato.APPROVATO.toString());

    	atletaGaraService.update(agDTO);
        return "redirect:/gara/show/"+idg;
    }
    
    @GetMapping("nonautorizza/{ida}/{idg}")
    public String nonautorizza(@PathVariable("ida") Integer ida, @PathVariable("idg") Integer idg, Model model) {
    	AtletaGaraDTO agDTO= atletaGaraService.getByDoubleId(ida, idg);
    	agDTO.setStato(AtletaGara.Stato.DISAPPROVATO.toString());

    	atletaGaraService.update(agDTO);
        return "redirect:/gara/show/"+idg;
    }
	
    @GetMapping("show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
    	GaraInsertDTO garadto = garaService.getById(id);
    	List<AtletaGaraDTO> atletig= atletaGaraService.findAtletaGaraByGaraId(id);
    	
    	model.addAttribute("atletig", atletig);
        model.addAttribute("gara",garadto);
        return "gara/show";
    }
	
    @PostMapping("crea")
    public String crea(@Valid @ModelAttribute("garaInsertDTO") GaraInsertDTO garainsertDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
        	List<DisciplinaInsertDTO> alldiscipline = disciplinaService.findAll();
    		model.addAttribute("discipline", alldiscipline);
            return "gara/crea";
        } else {
        	garainsertDTO.setStato(Gara.Stato.CREATA.toString());
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
