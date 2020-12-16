package it.solvingteam.olimpiadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.dto.AtletaSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.AtletaMapper;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.repository.AtletaRepository;
import it.solvingteam.olimpiadi.repository.RappresentanteNazioneRepository;

@Service
public class AtletaService {
	
	@Autowired
    private AtletaRepository atletaRepository;
	
	@Autowired
    private RappresentanteNazioneRepository rappresentanteNazioneRepository;
	
    @Autowired
    private AtletaMapper atletaMapper;
	
    public List<AtletaInsertDTO> findAll() {
        List<Atleta> allAtleti = this.atletaRepository.findAll();
        return atletaMapper.convertEntityToDto(allAtleti);
    }
    
    public List<AtletaInsertDTO> findBySearchParameter(AtletaSearchFilterDTO atletaSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Atleta> cq = cb.createQuery(Atleta.class);
//
//        Root<Atleta> customer = cq.from(Atleta.class);
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (customersSearchFilterDto.getId() != null && !customersSearchFilterDto.getId().equals("")) {
//            predicates.add(cb.like(customer.get("id").as(String.class), "%" + customersSearchFilterDto.getId() + "%"));
//        }
//
//        if (customersSearchFilterDto.getName() != null && !customersSearchFilterDto.getName().equals("")) {
//            predicates.add(cb.like(customer.get("name"), "%" + customersSearchFilterDto.getName() + "%"));
//        }
//
//        if (customersSearchFilterDto.getAddress() != null && !customersSearchFilterDto.getAddress().equals("")) {
//            predicates.add(cb.like(customer.get("address"), "%" + customersSearchFilterDto.getAddress() + "%"));
//        }
//
//        if (customersSearchFilterDto.getMobile() != null && !customersSearchFilterDto.getMobile().equals("")) {
//            predicates.add(cb.like(customer.get("mobile"), "%" + customersSearchFilterDto.getMobile() + "%"));
//        }
//
//        cq.where(predicates.toArray(new Predicate[0]));
//        return customerMapper.convertEntityToDto(entityManager.createQuery(cq).getResultList());
    	Util.stampa(this.toString());
    	return null;
    }
    
    public Atleta insert(AtletaInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	Atleta customer = new Atleta();
//    	if(id!=null) {
//    		customer.setId(Integer.parseInt(id));
//    	}
//    	customer.setName(name);
//    	customer.setMobile(mobile);
//    	customer.setAddress(address);
//        return this.customerRepository.save(customer);
    	Util.stampa(this.toString());
    	return null;
    }
    
    public void delete(AtletaInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	Atleta customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public AtletaInsertDTO getById(Integer id) {
    	return atletaMapper.convertEntityToDto(this.atletaRepository.findById(id).orElse(null));
    }

	public Atleta update(AtletaInsertDTO atletaDTO) {
    	String id= atletaDTO.getId();
    	String nome= atletaDTO.getNome();
    	String cognome= atletaDTO.getCognome();
    	String cf= atletaDTO.getCf();
    	String username= atletaDTO.getUsername();
    	String rappresentanteId= atletaDTO.getRappresentanteId();
    	String punti_totale= atletaDTO.getPunti_totale();
    	String oro= atletaDTO.getOro();
    	String argento= atletaDTO.getArgento();
    	String bronzo= atletaDTO.getBronzo();
    	String stato= atletaDTO.getStato();
    	
//    	String disciplinaId1;
//    	
//    	String disciplinaId2;
//    	
//    	String disciplinaId3;
    	Util.stampa(this.toString()+"ATTENZIONEEEEEEEEEEEEEEEEEEEEEEE");   		
    	Atleta atleta=new Atleta();
    	if(id!=null) {
    		atleta.setId(Integer.parseInt(id));
    	}

    	atleta.setNome(nome);
    	atleta.setCognome(cognome);
    	atleta.setCf(cf);
    	atleta.setUsername(username);
    	atleta.setRappresentante(rappresentanteNazioneRepository.findById(Integer.parseInt(rappresentanteId)).orElse(null));
    	atleta.setPunti_totale(Integer.parseInt(punti_totale));
    	atleta.setOro(Integer.parseInt(oro));
    	atleta.setArgento(Integer.parseInt(argento));
    	atleta.setBronzo(Integer.parseInt(bronzo));
    	atleta.setStato(Atleta.Stato.valueOf(stato));

    	
        return this.atletaRepository.save(atleta);	
	}

	public Optional<Atleta> findAtletaByUsername(String username) {
		return atletaRepository.findByUsername(username);
	}



}
