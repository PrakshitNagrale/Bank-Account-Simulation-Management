package exceptions;

public class NoAccountDetailsPresentException extends RuntimeException {
    public NoAccountDetailsPresentException(String message) {
        super(message);
    }
}
