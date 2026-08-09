package Excep;

public class TicketAlreadyExistException extends RuntimeException {
    String msg;


    public TicketAlreadyExistException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TicketAlreadyExistException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
