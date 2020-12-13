package it.solvingteam.olimpiadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.DisciplinaInsertDTO;
import it.solvingteam.olimpiadi.dto.DisciplinaSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.DisciplinaMapper;
import it.solvingteam.olimpiadi.model.Disciplina;
import it.solvingteam.olimpiadi.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
    private DisciplinaRepository disciplinaRepository;
	
    @Autowired
    private DisciplinaMapper disciplinaMapper;
	
    public List<DisciplinaInsertDTO> findAll() {
        List<Disciplina> allAtleti = this.disciplinaRepository.findAll();
        return disciplinaMapper.convertEntityToDto(allAtleti);
    }
    
    public List<DisciplinaInsertDTO> findBySearchParameter(DisciplinaSearchFilterDTO disciplinaSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Disciplina> cq = cb.createQuery(Disciplina.class);
//
//        Root<Disciplina> customer = cq.from(Disciplina.class);
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
    
    public Disciplina insert(DisciplinaInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	Disciplina customer = new Disciplina();
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
    
    public void delete(DisciplinaInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	Disciplina customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public DisciplinaInsertDTO getById(Integer id) {
//    	Disciplina c=this.customerRepository.findById(id).orElse(null);
//    	DisciplinaInsertDto cdto=new DisciplinaInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }

}
