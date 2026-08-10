package Service;

import Bean.Player;
import Bean.Sports;
import Bean.TournamentDetails;
import Excep.InvalidTournamnet;
import Excep.NoSportsExist;
import Excep.TournamentAlreadyExist;
import utility.AthleticsManagementInterface;

import java.util.ArrayList;
import java.util.List;

public class AthleteManagement implements AthleticsManagementInterface {

    List<TournamentDetails> tournamentDetails=new ArrayList<>();

    public void TounamentDetailsMethod(TournamentDetails t)throws TournamentAlreadyExist
    {
        for(TournamentDetails tour : tournamentDetails){
            if(tour.getTournamentId()== t.getTournamentId())
                throw new TournamentAlreadyExist("Already - Exist");
        }
        tournamentDetails.add(t);
    }

    @Override
    public void addNewTournament(TournamentDetails t) {

        tournamentDetails.add(t);
        System.out.println("List of Tournaments Available:-");
        System.out.println();
       tournamentDetails.stream().forEach(System.out::println);
    }

    @Override
    public boolean updateTournamentStatus(int Tournamentid, int sportId, String winner) {
        boolean f=false;
        for(TournamentDetails k: tournamentDetails){

            if(Tournamentid== k.getTournamentId()){
              f=true;
                for(Sports s: k.getSports()){
                    if(s.getSportId()== sportId){
                         s.setWinner("Yes");
                    }
            }

            }
        }
        if(!f)
            throw new InvalidTournamnet("Invalid Tournamnet ID-"+Tournamentid);
        return false;
    }

    @Override
    public List<Sports> retriveSports(int tournamentId)throws NoSportsExist {

        List<Sports> sp=new ArrayList<>();
        boolean f=false;
        for(TournamentDetails t : tournamentDetails){
            if(t.getTournamentId()== tournamentId){

                for(Sports s: t.getSports()){
                    if(s.getWinner().equals("No")){
                        f=true;
                       sp.add(s);
                    }
                }
            }
        }
       if(!f)
           throw new NoSportsExist("Invalid details ");
       return sp;
    }

    @Override
    public int findParticipationCount(int sportId) {
        int c=0;
        boolean f=false;
        for(TournamentDetails t: tournamentDetails){

            for(Sports s: t.getSports()){
                if(s.getSportId() == sportId) {
                    f=true;
                    c++;
                }
            }
            if(f)
                return c;
        }

        return 0;
    }

    @Override
    public List<Player> getAllPlayerwithExperience(int Excperience) {
        List<Player> play=new ArrayList<>();
        for(TournamentDetails t : tournamentDetails){
            for(Sports s: t.getSports()){
                for (Player p : s.getPlayer()){
                    if(p.getExperience()>=Excperience)
                        play.add(p);
                }
            }
        }
        return play;

    }
}
