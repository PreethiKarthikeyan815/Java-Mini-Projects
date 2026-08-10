package service;

import Bean.ResidentVehicle;
import Bean.Vehicle;
import Bean.VisitorVehicle;
import Excep.ParkingSlotNotAvailableException;
import Excep.vehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagement {
    private List<Vehicle> v=new ArrayList<>();

   public void addVehicle(Vehicle vehicle)
    {
        if(v.size()>=10)
            throw new ParkingSlotNotAvailableException("No Parking Slots Available");

        v.add(vehicle);
        if(vehicle instanceof ResidentVehicle)
            ((ResidentVehicle)(vehicle)).setParkinngStatus(true);
        System.out.println("Vehicle parked at Parking Slot no: "+v.size());
    }

    public String setVisitorVehicleOutTime(String regNumber, int outTime) {
        for(Vehicle k: v)
        {
            if(k.getRegNumber() .equals(regNumber) && k instanceof VisitorVehicle)
            {
            VisitorVehicle h=(VisitorVehicle)k;
            h.setOutTime(outTime);
            return "Vehicle with Reg Number:"+regNumber+"updated successfully";
            }

        }
        throw new vehicleNotFoundException("Searched Vehicle Not Found : "+regNumber);
    }

    public int getParkedResidentVehicleCount() {
        int c = 0;

        for (Vehicle k : v) {
            if (k instanceof ResidentVehicle)
                if (((ResidentVehicle) k).isParkinngStatus() )
                    c++;


        }
        return c;
    }

   public void displayAllVehicles()
    {
        v.stream().forEach(k-> System.out.println("RegisterNo: "+k.getRegNumber()+"\nOwenerName: "+k.getOwnerName()+"\nMobileNumber: "+k.getMobileNumber()+"\n"));
    }
}
