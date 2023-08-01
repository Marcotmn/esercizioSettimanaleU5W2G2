package marcotumminia.esercizioSettimanaleU5S2G2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;



import org.springframework.stereotype.Service;

import marcotumminia.esercizioSettimanaleU5S2G2.entities.Postazione;

@Service
public class PostazioneService {

	private List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione postazione) {
		Random rndm = new Random();
		postazione.setId(rndm.nextInt());
		this.postazioni.add(postazione);
		return postazione;
	}

	public List<Postazione> getPostazione() {
		return this.postazioni;
	}

	public Optional<Postazione> findById(int id) {
		Postazione po = null;

		for (Postazione postazione : postazioni) {
			if (postazione.getId() == id)
				po = postazione;
		}

		return Optional.ofNullable(po);
		
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator();

		while (iterator.hasNext()) {
			Postazione currentPostazione = iterator.next();
			if (currentPostazione.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Postazione> findByIdAndUpdate(int id, Postazione postazione) {
		Postazione found = null;

		for (Postazione currentPostazione : postazioni ) {
			if (currentPostazione.getId() == id) {
				found = currentPostazione;
				found.setDescrizione(postazione.getDescrizione());
				found.setTipoPostazione(postazione.getTipoPostazione());
				found.setMaxOccupanti(postazione.getMaxOccupanti());
				found.setDisponibilità(postazione.isDisponibilità());
				found.setCittà(postazione.getCittà());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}
