package repairechevreuilsbackend.repaire_chevreuils_backend.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long bookingId) {
        super("Could not find booking with id: " + bookingId);
    }
}
