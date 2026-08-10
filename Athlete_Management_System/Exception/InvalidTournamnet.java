package Excep;

public class InvalidTournamnet extends RuntimeException {
    String message;
    public InvalidTournamnet(String message) {

        super(message);
        this.message=message;
    }
}
