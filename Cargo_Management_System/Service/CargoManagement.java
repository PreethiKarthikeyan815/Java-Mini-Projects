package Service;

import Excep.InvalidPackageException;
import Excep.InvalidVehicleException;
import Excep.VehicleCapacityException;
import Inter.ManageCargo;
import bean.PackageDetails;
import bean.VehicleDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CargoManagement implements ManageCargo {

    List<VehicleDetails> vehicleDetails=new ArrayList<>();
    List<PackageDetails> packageDetails1=new ArrayList<>();

    // adding in list
     public void addVehiclesMethod(VehicleDetails vehicle)
     {
         vehicleDetails.add(vehicle);
     }
    // add in list packageDetails
     public void addPackagesMethod(PackageDetails pack)
     {
         packageDetails1.add(pack);
     }

    //check if the package is present or not
     public PackageDetails findPackage(int packageID)throws InvalidPackageException
     {
         for(PackageDetails k:packageDetails1) {
             if (packageID == k.getPackageID())
                 return k;
         }

             throw new InvalidPackageException("Invalid PackageID");

     }
     //dispaly vehicle details
     public void display()
     {
         vehicleDetails.stream().forEach(System.out::println);
     }
     //display package details
     public void displayPackageDetails()
     {
         packageDetails1.stream().forEach(System.out::println);
     }

     //  assign package to vehicle
    @Override
    public void addPackageToVechile(PackageDetails p, int v_id) throws InvalidVehicleException,VehicleCapacityException{
        boolean flag=false;
         for(VehicleDetails k:vehicleDetails)
         {
            if(k.getVehicleID()==v_id)
            {

                if (k.getCapacity()!=0)
                {
                    k.setCapacity(k.getCapacity()-1);
                    k.addPackage(p);
                    flag=true;
                    break;
                }
                else
                {
                    throw new VehicleCapacityException("Velicle is full");
                }

            }


         }
         if(!flag)
         throw new InvalidVehicleException("Invalid VehicleNo"+v_id);

    }

    //fetch package - vehicle details of the package
    @Override
    public VehicleDetails fetchPackage(int packageID) {

        // vehicleDetails.stream().map(k->k.getPackageDetails().getPackageID())
        for(VehicleDetails k:vehicleDetails)
        {
            for(PackageDetails p: k.getPackageDetails())
            {
                if(p.getPackageID()==packageID) {
                    System.out.println("Available:"+k.getCapacity());
                    return k;
                }
            }
        }
        return null;
    }

    //deliverpackage
    @Override
    public void deliverPackage(int packageID) {
         for(VehicleDetails k: vehicleDetails)
         {
             for(PackageDetails p: k.getPackageDetails())
             {
                 if(p.getPackageID()==packageID && p.getStatus().equals("Pending")){
                     p.setStatus("Delivered");
                     k.setCapacity(k.getCapacity()+1);
                     System.out.println("Available:"+k.getCapacity());
                 }

             }
         }

    }

    @Override
    public List<PackageDetails> deliveryPendingPackages() {
        List<PackageDetails> x=new ArrayList<>();
        for(VehicleDetails k: vehicleDetails)
        {
            for(PackageDetails p: k.getPackageDetails())
            {
                if(p.getStatus().equals("Pending"))
                {
                    p.setStatus("Delivered");
                    k.setCapacity(k.getCapacity()-1);
                }

            }
        }
        return x;
    }

    @Override
    public HashMap<Integer, Integer> fetchUndeliveredPackages() {
        HashMap<Integer, Integer> h=new HashMap<>();


        for(VehicleDetails k: vehicleDetails)
        {
            for(PackageDetails p: k.getPackageDetails())
            {
                if(p.getStatus().equals("Pending"))
                    h.put( k.getVehicleID(), h.getOrDefault(k.getVehicleID(), 0) + 1);
            }
        }
        return h;

        /*
        for(int i=0;i<vehicleDetails.size();i++)
        {
            for(int j=0;j<packageDetails.size();j++)

            {

            }
        }
        */
    }
}
