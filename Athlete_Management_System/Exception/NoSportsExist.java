package Excep;

public class NoSportsExist extends RuntimeException {
    String message;
    public NoSportsExist(String message) {
        super(message);
        this.message=message;
    }
}
