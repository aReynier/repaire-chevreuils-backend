package repairechevreuilsbackend.repaire_chevreuils_backend.exception;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(Long adminId) {
        super("Could not find admin with id: " + adminId);
    }
}
