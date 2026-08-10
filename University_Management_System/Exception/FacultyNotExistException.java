package Excep;

public class FacultyNotExistException extends RuntimeException {
    private String message;
    public FacultyNotExistException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "FacultyNotExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
