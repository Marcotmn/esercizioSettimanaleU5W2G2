package marcotumminia.esercizioSettimanaleU5S2G2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marcotumminia.esercizioSettimanaleU5S2G2.entities.Prenotazione;

import marcotumminia.esercizioSettimanaleU5S2G2.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")

public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@GetMapping("/ita")
	public String infoPrenotazioneIta() {
		return "Benvenuto, per prenotare una postazione abbiamo bisogno del tuo nome e del tuo username";
	}
	
	@GetMapping("/eng")
	public String infoPrenotazioneEng() {
		return "Welcome, please insert your name and username to make a reservation";
	}
	
	@GetMapping("/infoPrenotazione")
	public ResponseEntity<String> infoPrenotazione(@RequestParam(value = "lingua") String lingua) {
		if (lingua == null) {
			return ResponseEntity.badRequest().body("Inserisci una lingua tra italiano e inglese");
		}
		
		String messaggio;
		if(lingua.equalsIgnoreCase("italiano")) {
			messaggio = "Benvenuto, per prenotare una postazione abbiamo bisogno del tuo nome e del tuo username";
		}else if (lingua.equalsIgnoreCase("inglese")) {
			messaggio = "Welcome, please insert your name and username to make a reservation";
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lingua selezionata non è disponibile");
		}
		
		return ResponseEntity.ok(messaggio);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201
	public Prenotazione savePrenotazione(@RequestBody Prenotazione body) {
		Prenotazione createdPrenotazione = prenotazioneService.save(body);
		return createdPrenotazione;
	}
	
	@GetMapping("")
	public List<Prenotazione> getPrenotazione(){
		return prenotazioneService.getPrenotazioni();
	}


}
