package Excep;

public class SectionAlreadyExistException extends RuntimeException {
    private  String message;
    public SectionAlreadyExistException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "SectionAlreadyExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
