package repairechevreuilsbackend.repaire_chevreuils_backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
    // disponibilité OK si pas de réservation
    // en paramètre de la future , un identifiant de chambre, puis date de début et date de fin
    // a partir de l'identifiant , demander à la couche repository d'avoir les réservations correspondant à cette chambre

@SpringBootTest
public class BookingServiceTest {

	@Test
	void bookingOverlappingDate() {
        // Arrange
        // date de début de réservation demandée comprise entre la date de début et la date de fin de la réservation en cours
        Booking askedBooking = new Booking(LocalDate.of(2020, 1, 8));
        Booking currentBooking = new Booking(LocalDate.of(2020, 1, 10));

        BookingService bookingService = new BookingService();

        // Act
        boolean expected = bookingService.isRoomAvailable(askedBooking, currentBooking);

        // Assert
        assertEquals(expected, false);
	}
}

class BookingService {
    public boolean isRoomAvailable(Booking askedBooking, Booking currentBooking) {
        return false;
    }
}

class Booking {
    private LocalDate arrivalDate;

    Booking(LocalDate arrivalDate){
        this.arrivalDate = arrivalDate;
    }    
}