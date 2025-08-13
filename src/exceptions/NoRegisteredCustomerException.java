package exceptions;

public class NoRegisteredCustomerException extends RuntimeException {
    public NoRegisteredCustomerException(String message) {
        super(message);
    }
}
