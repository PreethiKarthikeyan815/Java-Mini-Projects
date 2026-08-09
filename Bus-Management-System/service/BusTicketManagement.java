package service;

import Bean.Bus;
import Bean.Passenger;
import Bean.SeniorCitizen;
import Bean.Ticket;
import Excep.InvalidBusException;
import Excep.LimitExceeddedException;
import Excep.TicketAlreadyExistException;
import Excep.TicketDoesNotPresentException;
import utility.BusManagementInterface;

import javax.naming.LimitExceededException;
import java.util.*;

public class BusTicketManagement implements BusManagementInterface {

    List<Bus> bus=new ArrayList<>();

     public BusTicketManagement() {

         int busno=1;
             // 3 busses
         Bus b = new Bus(busno++, "Thanjavur", "Chennai", new ArrayList<>());
         bus.add(b);
         Bus b1 = new Bus(busno++, "Chennai", "Thanjavur", new ArrayList<>());
         bus.add(b1);
         Bus b2 = new Bus(busno++, "Tirchy", "Thiruvarur", new ArrayList<>());
         bus.add(b2);
             /*
             for(int i=0;i<n;i++) {

                 System.out.println("Enter source and Destination for bus"+(i+1)+":");
                 System.out.println("Source:");

                 String source = sc.next();
                 System.out.println("Destination: ");
                 String destination = sc.next();

             }
             */
         }






    @Override
    public boolean issueTicket(int busNo, Ticket t) throws TicketAlreadyExistException, LimitExceeddedException {

         for(Bus k: bus)
          {
              if(k.getBusNo() == busNo) {
                  if (k.getTicket().size() >= 3)
                      throw new LimitExceeddedException("Bus is ALready Full");
                  System.out.println(k.getTicket().size());
                  for (Ticket x : k.getTicket()) {
                      if (x.getTicketNo() == t.getTicketNo())
                          throw new TicketAlreadyExistException("Ticket Already Exist- Invalid");
                  }


                  k.getTicket().add(t);
                  System.out.println(k.getTicket().size());
                  return true;
              }


          }
          return false;

    }

    @Override
    public HashMap<Integer, Integer> getCountOfSeniorCitizens() {

           HashMap<Integer , Integer> h=new HashMap<>();
         for(Bus k: bus)
         {
             for(Ticket x: k.getTicket())
             {
               if(x.getPassenger() instanceof SeniorCitizen)
                   h.put(k.getBusNo(), h.getOrDefault(k.getBusNo(),0)+1);

             }

         }
         return h;
    }

    @Override
    public boolean cancelTicket(int busNo, int ticketNo) throws TicketDoesNotPresentException, InvalidBusException {
       boolean g=false, f=false;
        for (Bus k : bus) {
            if (k.getBusNo() == busNo) {
                g=true;
                Iterator<Ticket> it = k.getTicket().iterator();
                while (it.hasNext()) {
                    Ticket x = it.next();
                    if (ticketNo == x.getTicketNo()) {
                        f=true;
                        it.remove();
                        return true;
                    }
                }

            }

        }
        if(!g)
       throw new InvalidBusException("Bus Not Exist");
        throw new TicketDoesNotPresentException("Ticket Not Found");
    }



    @Override
    public List<Passenger> getPassengersByGender(String gender) {
        List<Passenger> p=new ArrayList<>();

        for(Bus k: bus)
        {
            for(Ticket t : k.getTicket())
            {
                if(t.getPassenger().getGender().equals(gender))
                    p.add(t.getPassenger());
            }
        }
        return p;
    }

    @Override
    public long getCountOfPassenger(String source, String destination) {
         long c=0;
        for(Bus k: bus){
            for(Ticket t: k.getTicket())
            {
                if(t.getPassenger().getSource().equals(source) && t.getPassenger().getDestination().equals(destination))
                 c++;
            }
        }
        return c;
    }
}
