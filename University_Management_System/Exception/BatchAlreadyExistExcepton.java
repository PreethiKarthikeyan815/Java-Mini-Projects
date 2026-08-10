package Excep;

public class BatchAlreadyExistExcepton extends RuntimeException {
   private String message;
    public BatchAlreadyExistExcepton(String message) {

        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "BatchAlreadyExistExcepton{" +
                "message='" + message + '\'' +
                '}';
    }
}
