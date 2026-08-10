package Excep;

public class InvalidVehicleException extends Exception{
    String msg;

    public InvalidVehicleException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidVehicleException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
