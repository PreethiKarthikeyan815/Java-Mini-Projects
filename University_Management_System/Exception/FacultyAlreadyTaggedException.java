package Excep;

public class FacultyAlreadyTaggedException extends RuntimeException {
    private  String message;
    public FacultyAlreadyTaggedException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "FacultyAlreadyTaggedException{" +
                "message='" + message + '\'' +
                '}';
    }
}
