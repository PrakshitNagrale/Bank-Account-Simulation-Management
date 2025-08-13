package exceptions;

public class DuplicateAccountNumberException extends DuplicateIdException {
    public DuplicateAccountNumberException(String message) {
        super(message);
    }
}
