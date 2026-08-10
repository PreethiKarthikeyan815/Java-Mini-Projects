package Excep;

public class ScreenNotAvailableException extends RuntimeException {
    String message;
    public ScreenNotAvailableException(String message) {
        super(message);
        this.message=message;
    }
}
