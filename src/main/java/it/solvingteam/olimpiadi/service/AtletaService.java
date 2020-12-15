package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.AtletaGaraDTO;
import it.solvingteam.olimpiadi.dto.AtletaInsertDTO;
import it.solvingteam.olimpiadi.dto.AtletaSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.AtletaGaraMapper;
import it.solvingteam.olimpiadi.mapper.AtletaMapper;
import it.solvingteam.olimpiadi.model.Atleta;
import it.solvingteam.olimpiadi.model.AtletaGara;
import it.solvingteam.olimpiadi.repository.AtletaRepository;

@Service
public class AtletaService {
	
	@Autowired
    private AtletaRepository atletaRepository;
	
	@Autowired
    private AtletaGaraMapper atletaGaraMapper;
	
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
    
	public List<AtletaGaraDTO> findAtletaGaraByGaraId(Integer id) {
		List<AtletaGara> Atletig = this.atletaRepository.findAllAtletaGaraByGaraId(id);
		return atletaGaraMapper.convertEntityToDto(Atletig);
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
//    	Atleta c=this.customerRepository.findById(id).orElse(null);
//    	AtletaInsertDto cdto=new AtletaInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }



}
