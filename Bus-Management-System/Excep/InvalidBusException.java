package Excep;

public class InvalidBusException extends RuntimeException {

   String msg;

    public InvalidBusException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidBusException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
