package Excep;

public class ApplicantNotFound extends RuntimeException {
    String message;
    public ApplicantNotFound(String message) {

        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "ApplicantNotFound{" +
                "message='" + message + '\'' +
                '}';
    }
}
