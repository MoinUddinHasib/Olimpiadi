package it.solvingteam.olimpiadi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.GaraMapper;
import it.solvingteam.olimpiadi.model.Gara;
import it.solvingteam.olimpiadi.repository.DisciplinaRepository;
import it.solvingteam.olimpiadi.repository.GaraRepository;

@Service
public class GaraService {
	
	@Autowired
    private GaraRepository garaRepository;
	
	@Autowired
    private DisciplinaRepository disciplinaRepository;
	
    @Autowired
    private GaraMapper garaMapper;
    
    @Autowired
    private EntityManager entityManager;
	
    public List<GaraInsertDTO> findAll() {
        List<Gara> allGare = this.garaRepository.findAll();
        return garaMapper.convertEntityToDto(allGare);
    }
    
    public List<GaraInsertDTO> findBySearchParameter(GaraSearchFilterDTO garaSearchFilterDto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gara> cq = cb.createQuery(Gara.class);

        Root<Gara> gara = cq.from(Gara.class);
        List<Predicate> predicates = new ArrayList<>();

        if (garaSearchFilterDto.getNumero_partecipanti() != null && !garaSearchFilterDto.getNumero_partecipanti().equals("")) {
            predicates.add(cb.equal(gara.get("numero_partecipanti"), garaSearchFilterDto.getNumero_partecipanti() ));
        }
        
        if (garaSearchFilterDto.getDisciplinaId() != null && !garaSearchFilterDto.getDisciplinaId().equals("")) {
            predicates.add(cb.equal(gara.get("disciplina").get("id"), garaSearchFilterDto.getDisciplinaId()));
        }
        
        if (garaSearchFilterDto.getData() != null && !garaSearchFilterDto.getData().equals("")) {
            predicates.add(cb.equal(gara.get("data"), LocalDate.parse(garaSearchFilterDto.getData())));
        }
        
        if (garaSearchFilterDto.getStato() != null && !garaSearchFilterDto.getStato().equals("")) {
            predicates.add(cb.equal(gara.get("stato"), Gara.Stato.valueOf(garaSearchFilterDto.getStato()) ));
        }
        
        if (garaSearchFilterDto.getModificatore() != null && !garaSearchFilterDto.getModificatore().equals("")) {
            predicates.add(cb.equal(gara.get("modificatore"), garaSearchFilterDto.getModificatore() ));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return garaMapper.convertEntityToDto(entityManager.createQuery(cq).getResultList());

    }
    
    public Gara insert(GaraInsertDTO garaInsertDTO) {
    	String id= garaInsertDTO.getId();
    	Integer numero_partecipanti= garaInsertDTO.getNumero_partecipanti();
    	String disciplinaId= garaInsertDTO.getDisciplinaId();
    	String modificatore= garaInsertDTO.getModificatore();
    	
    	Gara gara = new Gara();
    	if(id!=null) {
    		gara.setId(Integer.parseInt(id));
    	}
    	gara.setNumero_partecipanti(numero_partecipanti);
    	gara.setDisciplina(disciplinaRepository.findById(Integer.parseInt(disciplinaId)).orElse(null));
    	gara.setModificatore(Integer.parseInt(modificatore));
    	gara.setData(LocalDate.now());
    	gara.setStato(Gara.Stato.CREATA);
        return this.garaRepository.save(gara);

    }
    
    public void delete(GaraInsertDTO garaInsertDTO) {
//    	String id= garaInsertDTO.getId();
//    	Gara gara=garaRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.garaRepository.delete(gara);
    	
    	Util.stampa(this.toString());
    }

    public GaraInsertDTO getById(Integer id) {
//    	Gara c=this.garaRepository.findById(id).orElse(null);
//    	GaraInsertDto cdto=new GaraInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }

}
