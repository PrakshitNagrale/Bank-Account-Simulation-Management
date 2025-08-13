package exceptions;

public class DuplicateCustomerIdException extends DuplicateIdException {
    public DuplicateCustomerIdException(String message) {
        super(message);
    }
}
