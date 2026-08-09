package Excep;

public class TicketDoesNotPresentException extends RuntimeException {
    String message;

    public TicketDoesNotPresentException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TicketDoesNotPresentException{" +
                "message='" + message + '\'' +
                '}';
    }
}

