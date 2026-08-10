package Excep;

public class MovieNotFoundException extends RuntimeException {
    String message;

    public MovieNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
