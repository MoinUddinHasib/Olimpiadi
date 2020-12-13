package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.NazioneInsertDTO;
import it.solvingteam.olimpiadi.dto.NazioneSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.NazioneMapper;
import it.solvingteam.olimpiadi.model.Nazione;
import it.solvingteam.olimpiadi.repository.NazioneRepository;

@Service
public class NazioneService {
	
	@Autowired
    private NazioneRepository nazioneRepository;
	
    @Autowired
    private NazioneMapper nazioneMapper;
	
    public List<NazioneInsertDTO> findAll() {
        List<Nazione> allAtleti = this.nazioneRepository.findAll();
        return nazioneMapper.convertEntityToDto(allAtleti);
    }
    
    public List<NazioneInsertDTO> findBySearchParameter(NazioneSearchFilterDTO nazioneSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Nazione> cq = cb.createQuery(Nazione.class);
//
//        Root<Nazione> customer = cq.from(Nazione.class);
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
    
    public Nazione insert(NazioneInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	Nazione customer = new Nazione();
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
    
    public void delete(NazioneInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	Nazione customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public NazioneInsertDTO getById(Integer id) {
//    	Nazione c=this.customerRepository.findById(id).orElse(null);
//    	NazioneInsertDto cdto=new NazioneInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }

}
