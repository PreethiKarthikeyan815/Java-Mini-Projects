package Driver;


import Excep.InvalidPackageException;
import Excep.InvalidVehicleException;
import Excep.VehicleCapacityException;
import Service.CargoManagement;
import bean.AirCargoDetails;
import bean.PackageDetails;
import bean.TruckDetails;
import bean.VehicleDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch; String vehicleName;
        CargoManagement cm = new CargoManagement();

        do {
            System.out.println("Cargo Management System");
            System.out.println("1----->Add new Truck");
            System.out.println("2----->Add new Package");
            System.out.println("3-----> Add package to Vechicle");
            System.out.println("4----->FetchPackage");
            System.out.println("5----->DeliverPackage");
            System.out.println("6----->DeliverPendingPackage");
            System.out.println("7----->Fetch UndelivereddPackages");
            //System.out.println("8----->Full Details of Vehile and packages");
            System.out.println("8----->exit");
            System.out.println("Enter your Choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter VehileID, capacity:");
                    int vehicleID = sc.nextInt();

                    int capacity = sc.nextInt();
                    System.out.println("vehicleName: Truck----->1 \nAirCargo----->2");
                    System.out.println("Enetr Your Choice:");
                    int n=sc.nextInt();
                    if(n==1)
                        vehicleName = "Truck";
                    else
                        vehicleName="AirCargo";
                    if (vehicleName.equals("Truck")) {
                        System.out.println("Enter roadTax:");
                        double roadTax = sc.nextDouble();
                        TruckDetails td = new TruckDetails(vehicleID, vehicleName, capacity,new ArrayList<>(), roadTax);
                        cm.addVehiclesMethod(td); // we cant use constructor in service so we use method
                    } else if(vehicleName.equals("AirCargo")){
                        System.out.println("Enter airForce Tax:");
                        double airForce = sc.nextDouble();
                        AirCargoDetails ac = new AirCargoDetails(vehicleID, vehicleName, capacity, new ArrayList<>(), airForce);
                        cm.addVehiclesMethod(ac);
                    } else
                        System.out.println("Invalid Choice:");
                    System.out.println("VehicleDetails:");
                    cm.display();
                    break;
                case 2:
                    System.out.println("Add New package");
                    System.out.println("Enter PackageId:");
                    int packageID = sc.nextInt();
                    PackageDetails pd = new PackageDetails(packageID, "Pending");
                    cm.addPackagesMethod(pd);
                    cm.displayPackageDetails();

                    break;
                case 3:
                    System.out.println("Add Package to Vechicle");
                    System.out.println("Enter package to put on vechile");
                    int p_no = sc.nextInt();
                    System.out.println("Enter Vechile number to put Package: ");
                    int v_no = sc.nextInt();
                    try {
                        PackageDetails p = cm.findPackage(p_no);
                        cm.addPackageToVechile(p, v_no);
                        System.out.println("VehicleDetails:");
                        cm.display();
                    } catch (InvalidPackageException ipe) {
                        System.out.println(ipe);
                    } catch (InvalidVehicleException ive) {
                        System.out.println(ive);
                    } catch (VehicleCapacityException vce) {
                        System.out.println(vce);
                    }
                    break;
                case 4:
                    System.out.println("VehicleDetails:");
                    cm.display();
                    System.out.println("Fetch Package");
                    System.out.println("Enter PackageID");
                    int id = sc.nextInt();
                    System.out.println("Vechile has Following Packages:" + cm.fetchPackage(id));
                    System.out.println("VehicleDetails:");
                    cm.display();
                    break;
                case 5:
                    System.out.println("VehicleDetails:");
                    cm.display();
                    System.out.println("Enter packageID to deliver:");
                    int id1 = sc.nextInt();
                    cm.deliverPackage(id1);
                    System.out.println("VehicleDetails:");
                    cm.display();
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("VehicleDetails:");
                    cm.display();
                    System.out.println("");
                    System.out.println("Delivery Pending Packages");
                    System.out.println("Pending Packages:" + cm.deliveryPendingPackages());
                    System.out.println("VehicleDetails:");
                    cm.display();
                    break;
                case 7:
                    System.out.println("VehicleDetails Before:");
                    cm.display();
                    System.out.println("");
                    System.out.println("Fetch Undelivered Packages in each Vehicle");
                    System.out.println("");
                    System.out.println("Undelivered Packages" + cm.fetchUndeliveredPackages());
                    System.out.println("");
                    System.out.println("VehicleDetails:");
                    cm.display();
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("");
                    cm.display();
                    System.out.println("");
                    break;
                case 9:
                    break;
            }
        } while (ch != 9);
    }
}
