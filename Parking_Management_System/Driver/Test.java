package Main;

import Bean.ResidentVehicle;
import Bean.VisitorVehicle;
import service.ParkingManagement;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
int f_no, ch;
    ParkingManagement pp=new ParkingManagement();

    do

    {
        System.out.println("Parking Management System");
        System.out.println("1----> Add vehicle");
        System.out.println("2----> Setting Visitors  Vehicle OutTime");
        System.out.println("3----> Count Of Parked Residence Vehicle Count");
        System.out.println("4----> Display All Vehicle");
        System.out.println("5----> Exit");
        System.out.println("Enter your Choice");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("----- Add Vehicle-----");
                System.out.println("Enter registration No:");
                String reg_no = sc.next();
                System.out.println("Enter Name");
                String name = sc.next();
                System.out.println("Enter Mobile No");
                long no = sc.nextLong();
                System.out.println();
                System.out.println("Are you Residant or Visitor \n1--->Residant\n2--->Visitor");
                int i = sc.nextInt();
                if (i == 1) {
                    System.out.println(" Residant's Parking");
                    System.out.println("Enter FlatNo:");
                    f_no = sc.nextInt();
                    ResidentVehicle r = new ResidentVehicle(reg_no, name, no, f_no, false);
                    pp.addVehicle(r);
                } else {
                    System.out.println("Visitor Parkaring");
                    System.out.println("Enter Flat No:");
                    f_no= sc.nextInt();
                    System.out.println("Enter In Time :");
                    int time = sc.nextInt();
                    VisitorVehicle v = new VisitorVehicle(reg_no, name, no, f_no, time);
                    pp.addVehicle(v);

                }

                break;
            case 2:
                System.out.println("Setting Visitor OutTime-- Takking Vehicle Out");
                System.out.println("Enter Regiater No");
                String n = sc.next();
                System.out.println("Enter Time of Taking a vehicle:");
                int tim = sc.nextInt();
                System.out.println("Status : \n" + pp.setVisitorVehicleOutTime(n, tim));
                break;
            case 3:
                System.out.println("Count Of Parked Residence Vehicle Count");
                System.out.println("count = " + pp.getParkedResidentVehicleCount());
                System.out.println();
                break;
            case 4:
                System.out.println("Details of All parkedd Vehicle ");
                System.out.println();
                pp.displayAllVehicles();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Choice ");
        }
    }while(ch!=5);



        }

}
