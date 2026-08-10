package utility;

import Bean.Player;
import Bean.Sports;
import Bean.TournamentDetails;
import Excep.InvalidTournamnet;
import Excep.NoSportsExist;
import Excep.TournamentAlreadyExist;

import java.util.List;

public interface AthleticsManagementInterface {
    public void  addNewTournament(TournamentDetails t) throws TournamentAlreadyExist;
    public boolean updateTournamentStatus(int TournamentStatus, int sportId, String winner)throws InvalidTournamnet;

    public List<Sports> retriveSports(int tournamentId)throws NoSportsExist;
    public int findParticipationCount(int sportId);
    public List<Player> getAllPlayerwithExperience(int Excperience);

}
