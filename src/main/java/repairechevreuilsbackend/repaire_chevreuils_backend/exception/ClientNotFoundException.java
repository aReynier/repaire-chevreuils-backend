package repairechevreuilsbackend.repaire_chevreuils_backend.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long clientId) {
        super("Could not find client with id: " + clientId);
    }
}
