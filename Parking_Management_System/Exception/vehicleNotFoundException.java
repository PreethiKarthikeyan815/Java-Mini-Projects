package Excep;

public class vehicleNotFoundException extends RuntimeException {
    private String message;

    public vehicleNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "vehicleNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}
