package repairechevreuilsbackend.repaire_chevreuils_backend.exception;

public class GuestRoomNotFoundException extends RuntimeException {
    public GuestRoomNotFoundException(Long guestRoomId) {
        super("Could not find guestRoom with id: " + guestRoomId);
    }
}
