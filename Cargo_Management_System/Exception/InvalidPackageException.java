package Excep;

public class InvalidPackageException extends Exception{
    String msg;



    public InvalidPackageException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InvalidPackageException{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
