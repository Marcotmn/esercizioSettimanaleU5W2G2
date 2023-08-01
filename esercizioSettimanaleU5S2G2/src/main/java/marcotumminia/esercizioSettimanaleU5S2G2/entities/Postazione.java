package marcotumminia.esercizioSettimanaleU5S2G2.entities;

import java.util.UUID;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import marcotumminia.esercizioSettimanaleU5S2G2.Enum.TipoPostazione;

@Getter
@Setter

@NoArgsConstructor
@ToString

public class Postazione {
	 

	private Prenotazione prenotazione;
	private TipoPostazione tipoPostazione;
	
	private int id;
	private String descrizione;
	
	
	private int maxOccupanti;
	private boolean disponibilità;
	private String città;

	public Postazione (String descrizione, TipoPostazione tipoPostazione, int maxOccupanti, boolean disponibilità, String città) {
		
		this.descrizione = descrizione;
		this.tipoPostazione = tipoPostazione;
		this.maxOccupanti = maxOccupanti;
		this.disponibilità = disponibilità;
		this.città = città;
	}
	
}
