package Excep;

public class NotEnoughStockException extends RuntimeException {
    String message;

    public NotEnoughStockException(String message) {

        super(message);
        this.message = message;
    }
}
