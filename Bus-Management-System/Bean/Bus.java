package Bean;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private int busNo;
    private String startStation;
    private String destinationStation;
    private List<Ticket> ticket;


    public Bus(int busNo, String startStation, String destinationStation, List<Ticket> ticket) {
        this.busNo = busNo;
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.ticket =ticket;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNo=" + busNo +
                ", startStation='" + startStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
