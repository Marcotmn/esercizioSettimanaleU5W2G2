package marcotumminia.esercizioSettimanaleU5S2G2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marcotumminia.esercizioSettimanaleU5S2G2.entities.Postazione;
import marcotumminia.esercizioSettimanaleU5S2G2.services.PostazioneService;


@RestController
@RequestMapping("/users")
public class PostazioneController {
	@Autowired
	PostazioneService postazioneService;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201
	public Postazione savePostazione(@RequestBody Postazione body) {
		Postazione createdPostazione = postazioneService.save(body);
		return createdPostazione;
	}

	@GetMapping("")
	public List<Postazione> getPostazione(){
		return postazioneService.getPostazione();
	}

}
