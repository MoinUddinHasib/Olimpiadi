package it.solvingteam.olimpiadi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.model.Disciplina;
import it.solvingteam.olimpiadi.model.Nazione;
import it.solvingteam.olimpiadi.model.Utente;
import it.solvingteam.olimpiadi.service.DisciplinaService;
import it.solvingteam.olimpiadi.service.NazioneService;
import it.solvingteam.olimpiadi.service.UtenteService;

@Component
public class OlimpiadiApplicationRunner implements ApplicationRunner {
	
	@Autowired
    private UtenteService utenteService;
	
	@Autowired
    private DisciplinaService disciplinaService;
	
	@Autowired
    private NazioneService nazioneService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (utenteService.count() == 0) {
            Utente u = new Utente();
                        
            u.setNome("Hasib");
            u.setCognome("Moin Uddin");
            u.setCf("MNDHSB96A21H501E");
            u.setUsername("h");
            u.setPassword(new BCryptPasswordEncoder().encode("pw"));            
            u.setRuolo(Utente.Ruolo.ORGANIZZATORE);
            
            utenteService.save(u);
        }
		
		if (disciplinaService.count() == 0) {
			Disciplina d = new Disciplina();
			d.setNome("Calcio");
			disciplinaService.save(d);
			
			Disciplina d1 = new Disciplina();
			d1.setNome("Badminton");
			disciplinaService.save(d1);
			
			Disciplina d2 = new Disciplina();
			d2.setNome("Vela");
			disciplinaService.save(d2);
			
			Disciplina d3 = new Disciplina();
			d3.setNome("Nuoto");
			disciplinaService.save(d3);
			
			Disciplina d4 = new Disciplina();
			d4.setNome("Sollevamento pesi");
			disciplinaService.save(d4);
			
			Disciplina d5 = new Disciplina();
			d5.setNome("Scherma");
			disciplinaService.save(d5);
		}
		
		if (nazioneService.count() == 0) {
			Nazione n = new Nazione();
			n.setNome("Italia");
			nazioneService.save(n);
			
			Nazione n1 = new Nazione();
			n1.setNome("Bangladesh");
			nazioneService.save(n1);
			
			Nazione n2 = new Nazione();
			n2.setNome("Francia");
			nazioneService.save(n2);
			
			Nazione n3 = new Nazione();
			n3.setNome("Regno Unito");
			nazioneService.save(n3);
			
			Nazione n4 = new Nazione();
			n4.setNome("Germania");
			nazioneService.save(n4);
			
			Nazione n5 = new Nazione();
			n5.setNome("Irlanda");
			nazioneService.save(n5);
		}

	}

}
