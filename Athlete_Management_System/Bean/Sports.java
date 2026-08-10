package Bean;

import java.util.ArrayList;
import java.util.List;

public class Sports {

    private int sportId;
    private String sportName;
    private String gameType;
    private String winner;
    private List<Player> player;

    public Sports(int sportId, String sportName, String gameType, String winner, List<Player> player) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.gameType = gameType;
        this.winner = winner;
        this.player = player;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        winner = winner;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "sportId=" + sportId +
                ", sportName='" + sportName + '\'' +
                ", gameType='" + gameType + '\'' +
                ", winner='" + winner + '\'' +
                ", player=" + player +
                '}';
    }
}


