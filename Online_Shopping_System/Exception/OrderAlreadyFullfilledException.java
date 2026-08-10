package Excep;

public class OrderAlreadyFullfilledException extends RuntimeException {
    String message;

    public OrderAlreadyFullfilledException(String message) {

        super(message);
     this.message = message;

    }
}
