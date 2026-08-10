package Excep;

public class VehicleCapacityException extends Exception {
    String msg;

    public VehicleCapacityException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "VehicleCapacityException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
