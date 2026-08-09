package utility;

import java.util.HashMap;

public class TicketNoGenerator {
    HashMap<Integer, Integer> h=new HashMap<>();
    public int generateTicketNo(int busNo ){



        h.put(busNo, h.getOrDefault(busNo,0)+1);
        return h.get(busNo);


    }
}
