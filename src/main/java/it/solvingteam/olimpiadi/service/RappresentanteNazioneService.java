package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.RappresentanteNazioneInsertDTO;
import it.solvingteam.olimpiadi.dto.RappresentanteNazioneSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.RappresentanteNazioneMapper;
import it.solvingteam.olimpiadi.model.RappresentanteNazione;
import it.solvingteam.olimpiadi.repository.RappresentanteNazioneRepository;

@Service
public class RappresentanteNazioneService {
	
	@Autowired
    private RappresentanteNazioneRepository atletaRepository;
	
    @Autowired
    private RappresentanteNazioneMapper atletaMapper;
	
    public List<RappresentanteNazioneInsertDTO> findAll() {
        List<RappresentanteNazione> allAtleti = this.atletaRepository.findAll();
        return atletaMapper.convertEntityToDto(allAtleti);
    }
    
    public List<RappresentanteNazioneInsertDTO> findBySearchParameter(RappresentanteNazioneSearchFilterDTO atletaSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<RappresentanteNazione> cq = cb.createQuery(RappresentanteNazione.class);
//
//        Root<RappresentanteNazione> customer = cq.from(RappresentanteNazione.class);
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
    
    public RappresentanteNazione insert(RappresentanteNazioneInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	RappresentanteNazione customer = new RappresentanteNazione();
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
    
    public void delete(RappresentanteNazioneInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	RappresentanteNazione customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public RappresentanteNazioneInsertDTO getById(Integer id) {
//    	RappresentanteNazione c=this.customerRepository.findById(id).orElse(null);
//    	RappresentanteNazioneInsertDto cdto=new RappresentanteNazioneInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }

}
