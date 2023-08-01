package marcotumminia.esercizioSettimanaleU5S2G2.entities;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString

public class Prenotazione {


	private User user;
	private int id;
    private LocalDate reservationDate;
    
    public Prenotazione (User user, LocalDate reservationDate) {
    	this.user = user;
    	this.reservationDate = reservationDate;
    }
}