package Excep;

public class OrderNotFoundException extends RuntimeException {
    String  message;

    public OrderNotFoundException(String message) {

        super(message);
        this.message=message;
    }
}
