package marcotumminia.esercizioSettimanaleU5S2G2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;


import org.springframework.stereotype.Service;

import marcotumminia.esercizioSettimanaleU5S2G2.entities.Prenotazione;

@Service
public class PrenotazioneService {

	private List<Prenotazione> prenotazioni = new ArrayList<>();

	public Prenotazione save(Prenotazione prenotazione) {
		Random rndm = new Random();
		prenotazione.setId(rndm.nextInt());
		this.prenotazioni.add(prenotazione);
		return prenotazione;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public Optional<Prenotazione> findById(int id) {
		Prenotazione p = null;

		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id)
				p = prenotazione;
		}

		return Optional.ofNullable(p);
		
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Prenotazione> iterator = this.prenotazioni.listIterator();

		while (iterator.hasNext()) {
			Prenotazione currentPrenotazione = iterator.next();
			if (currentPrenotazione.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Prenotazione> findByIdAndUpdate(int id, Prenotazione prenotazione) {
		Prenotazione found = null;

		for (Prenotazione currentPrenotazione : prenotazioni) {
			if (currentPrenotazione.getId() == id) {
				found = currentPrenotazione;
				found.setUser(prenotazione.getUser());
				found.setReservationDate(prenotazione.getReservationDate());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}