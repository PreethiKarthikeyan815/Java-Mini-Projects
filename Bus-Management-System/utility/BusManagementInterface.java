package utility;

import Bean.Passenger;
import Bean.Ticket;
import Excep.InvalidBusException;
import Excep.TicketAlreadyExistException;
import Excep.TicketDoesNotPresentException;

import javax.naming.LimitExceededException;
import java.util.HashMap;
import java.util.List;

public interface BusManagementInterface {
    public  boolean issueTicket(int busNo, Ticket t) throws TicketAlreadyExistException, LimitExceededException;

    public HashMap<Integer, Integer> getCountOfSeniorCitizens();

    public boolean cancelTicket(int busNo, int ticketNo) throws TicketDoesNotPresentException, InvalidBusException;

    public List<Passenger> getPassengersByGender(String gender);

    public long getCountOfPassenger(String  source, String destination);




}
