package Bean;

import java.util.List;

public class Tennis extends Sports{

    public Tennis(int sportId, String sportName, String gameType, String winner, List<Player> player) {
        super(sportId, sportName, gameType, winner, player);
    }

    @Override
    public String toString() {
        return "Tennis{}";
    }

}
