package Excep;

public class SectionStreamNotMatchedException extends RuntimeException {
    private String message;

    public SectionStreamNotMatchedException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String toString() {
        return "SectionStreamNotMatchedException{" +
                "message='" + message + '\'' +
                '}';
    }
}
