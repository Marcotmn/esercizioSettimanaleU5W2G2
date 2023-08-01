package entities;

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
	private UUID id;
    private LocalDate reservationDate;
    
    public Prenotazione (Postazione postazione, User user, LocalDate reservationDate) {
    	this.user = user;
    	this.reservationDate = reservationDate;
    }
}