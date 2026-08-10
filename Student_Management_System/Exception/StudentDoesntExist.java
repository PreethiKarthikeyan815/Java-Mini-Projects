package Excep;

public class StudentDoesntExist extends RuntimeException {
    String message;
    public StudentDoesntExist(String message) {

        super(message);
     this.message=message;
    }
}
