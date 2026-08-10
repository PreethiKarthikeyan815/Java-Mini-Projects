package Excep;

public class ParkingSlotNotAvailableException extends RuntimeException {
    private String message;
    public ParkingSlotNotAvailableException(String message)
    {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "ParkingSlotNotAvailableException{" +
                "message='" + message + '\'' +
                '}';
    }
}
