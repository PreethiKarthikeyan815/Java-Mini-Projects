package Bean;

import java.util.List;

public class Theatre {
    private int theatreId;
    private String name;
    private String address;
    private int noOfScreens;
    private List<Screen> screens;

    public Theatre(int theatreId, String name, String address, int noOfScreens, List<Screen> screens) {
        this.theatreId = theatreId;
        this.name = name;
        this.address = address;
        this.noOfScreens = noOfScreens;
        this.screens = screens;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(int noOfScreens) {
        this.noOfScreens = noOfScreens;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", noOfScreens=" + noOfScreens +
                ", screens=" + screens +
                '}';
    }
}
