package it.solvingteam.olimpiadi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.solvingteam.olimpiadi.model.Utente;
import it.solvingteam.olimpiadi.service.UtenteService;

@Component
public class OlimpiadiApplicationRunner implements ApplicationRunner {
	
	@Autowired
    private UtenteService utenteService;

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

	}

}
