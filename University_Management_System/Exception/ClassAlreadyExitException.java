package Excep;

public class ClassAlreadyExitException extends RuntimeException {
    private  String message;

    public ClassAlreadyExitException(String message) {

        super(message);
       this.message=message;
    }

    @Override
    public String toString() {
        return "ClassAlreadyExitException{" +
                "message='" + message + '\'' +
                '}';
    }
}
