package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.GaraInsertDTO;
import it.solvingteam.olimpiadi.dto.GaraSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.GaraMapper;
import it.solvingteam.olimpiadi.model.Gara;
import it.solvingteam.olimpiadi.repository.GaraRepository;

@Service
public class GaraService {
	
	@Autowired
    private GaraRepository garaRepository;
	
    @Autowired
    private GaraMapper garaMapper;
	
    public List<GaraInsertDTO> findAll() {
        List<Gara> allAtleti = this.garaRepository.findAll();
        return garaMapper.convertEntityToDto(allAtleti);
    }
    
    public List<GaraInsertDTO> findBySearchParameter(GaraSearchFilterDTO garaSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Gara> cq = cb.createQuery(Gara.class);
//
//        Root<Gara> customer = cq.from(Gara.class);
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
    
    public Gara insert(GaraInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	Gara customer = new Gara();
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
    
    public void delete(GaraInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	Gara customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public GaraInsertDTO getById(Integer id) {
//    	Gara c=this.customerRepository.findById(id).orElse(null);
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
