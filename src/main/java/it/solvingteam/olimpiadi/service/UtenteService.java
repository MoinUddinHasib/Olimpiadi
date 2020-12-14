package it.solvingteam.olimpiadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.solvingteam.olimpiadi.Util;
import it.solvingteam.olimpiadi.dto.UtenteInsertDTO;
import it.solvingteam.olimpiadi.dto.UtenteSearchFilterDTO;
import it.solvingteam.olimpiadi.mapper.UtenteMapper;
import it.solvingteam.olimpiadi.model.UserPrincipal;
import it.solvingteam.olimpiadi.model.Utente;
import it.solvingteam.olimpiadi.repository.UtenteRepository;

@Service
public class UtenteService implements UserDetailsService {
	
	@Autowired
    private UtenteRepository utenteRepository;
	
    @Autowired
    private UtenteMapper atletaMapper;
	
    public List<UtenteInsertDTO> findAll() {
        List<Utente> allAtleti = this.utenteRepository.findAll();
        return atletaMapper.convertEntityToDto(allAtleti);
    }
    
    public List<UtenteInsertDTO> findBySearchParameter(UtenteSearchFilterDTO atletaSearchFilterDto) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
//
//        Root<Utente> customer = cq.from(Utente.class);
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
    
    public Utente insert(UtenteInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	String name= customerinsertDto.getName();
//    	String mobile= customerinsertDto.getMobile();
//    	String address= customerinsertDto.getAddress();
//    	
//    	Utente customer = new Utente();
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
    
    public void delete(UtenteInsertDTO customerinsertDto) {
//    	String id= customerinsertDto.getId();
//    	Utente customer=customerRepository.findById(Integer.parseInt(id)).orElse(null);
//        this.customerRepository.delete(customer);
    	
    	Util.stampa(this.toString());
    }

    public UtenteInsertDTO getById(Integer id) {
//    	Utente c=this.customerRepository.findById(id).orElse(null);
//    	UtenteInsertDto cdto=new UtenteInsertDto();
//    	cdto.setId(c.getId().toString());
//    	cdto.setName(c.getName());
//    	cdto.setMobile(c.getMobile());
//    	cdto.setAddress(c.getAddress());
//    	return c==null?null:cdto;
    	
    	Util.stampa(this.toString());
    	return null;
    }
    
    public long count() {
        return this.utenteRepository.count();
    }
    
    public Utente save(Utente role) {
        return this.utenteRepository.save(role);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente = utenteRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserPrincipal(utente);
	}
	
    public Optional<Utente> findUserByUSername(String username) {
        return utenteRepository.findByUsername(username);
    }

}
