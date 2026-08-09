package Excep;

public class LimitExceeddedException extends RuntimeException {
    String message;

    public LimitExceeddedException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "LimitExceeddedException{" +
                "message='" + message + '\'' +
                '}';
    }
}
