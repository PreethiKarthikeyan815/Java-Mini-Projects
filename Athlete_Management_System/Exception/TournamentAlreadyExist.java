package Excep;

public class TournamentAlreadyExist extends RuntimeException {
    String message;
    public TournamentAlreadyExist(String message) {
        super(message);
        this.message=message;
    }
}
