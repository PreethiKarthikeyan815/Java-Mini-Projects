package Main;

import Bean.Bus;
import Bean.Passenger;
import Bean.SeniorCitizen;
import Bean.Ticket;
import Excep.InvalidBusException;
import Excep.LimitExceeddedException;
import Excep.TicketAlreadyExistException;
import Excep.TicketDoesNotPresentException;

import service.BusTicketManagement;
import utility.TicketNoGenerator;

import javax.naming.LimitExceededException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch;
        double tp, ticket_Price = 1000;
        int age=0; boolean cond;
        String source, destination, gender;
        BusTicketManagement b = new BusTicketManagement();
        TicketNoGenerator tng = new TicketNoGenerator();

        do {
            System.out.println("Bus Management System");
            System.out.println("1----->Issue Ticket ");
            System.out.println("2----->Get Count of Senior citizen");
            System.out.println("3-----> Cancel Ticket");
            System.out.println("4----->Get Passengers by Gender");
            System.out.println("5----->Get Count Of  Passengers");
            System.out.println("6----->Exit");
            System.out.println();
            System.out.println("Enter You Choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    try {

                        System.out.println("Issue Ticket");
                        System.out.println("Enter  PassengerName:");

                        String passengerName = sc.next();
                        System.out.println("Enter Gender 1--->Male\n2--->Female");
                        int a=sc.nextInt();
                        if(a==1)
                            gender="Male";
                        else
                            gender="Female";

                        System.out.println("Enter your Choice --> source ");
                        System.out.println("1---->Thanjavur to Chennai");
                        System.out.println("2---->Chennai Thanjavur");
                        System.out.println("3----> Trichy to Thiruvarur");
                        System.out.println("Invalid Choid Leads to option 3 as source station");
                        int busNo=sc.nextInt();
                        if(busNo==1) {
                            source = "Thanjavur"; destination="Chennai";
                        }
                        else if(busNo==2){
                            source="Chennai";  destination="Thanjavur";
                        }
                        else {
                            source = "Trichy"; destination="Thiruvarur";
                        }


                        System.out.println("Are you a Senior citizen \n1--->yes \n 2--->No");
                        int f = sc.nextInt();
                        //TicketNOGenerator Object

                        int ticket_No = tng.generateTicketNo(busNo);

                        if (f == 2) {
                            tp = ticket_Price + 100;
                            Passenger p = new Passenger(passengerName, gender, source, destination);
                            Ticket t = new Ticket(ticket_No, tp, p);
                            cond=b.issueTicket(busNo, t);
                            System.out.println("Whether Ticket  booked ?: " +cond );
                        } else {
                            tp = ticket_Price - 200;
                            System.out.println("Enter age:");
                            age = sc.nextInt();
                            SeniorCitizen s = new SeniorCitizen(passengerName, gender, source, destination, age);
                            Ticket t = new Ticket(ticket_No, tp, s);
                            cond= b.issueTicket(busNo, t);
                            System.out.println("Whether Ticket  booked ?: " +cond);
                        }
                        // Bus b=new Bus(busNo, startStation, destinationStation);


                        if(cond) {
                            System.out.println();
                            System.out.println("Congrats!! Your Ticket is Conformed....");
                            System.out.println();
                            System.out.println("Details Of Ticket ");
                            System.out.println();
                            System.out.println("       <3---Welcome To Simren's Travels---<3      ");
                            System.out.println();
                            System.out.println("          Happy Journey !!!!     ");
                            System.out.println("Bus StartStation:  " + source + "----->" + "Destination_Station : " + destination);
                            System.out.println();
                            System.out.println("Ticket No"+ticket_No);
                            System.out.println();
                            System.out.println("Passenger Details");
                            System.out.println();
                            System.out.println("Passenger_Name: " + passengerName);
                            System.out.println("Gender : " + gender);
                            System.out.println("Source: " + source);
                            System.out.println("Destination : " + destination);
                            if (f != 2) {
                                System.out.println("Senior_Citizen");
                                System.out.println("Age: " + age);
                            }
                        }
                    } catch (TicketAlreadyExistException taee) {
                        System.out.println(taee);
                    } catch (LimitExceeddedException lee) {
                        System.out.println(lee);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Get Count Of Senior Citizen");
                    System.out.println();
                    System.out.println("Count Of Senior Citizens: " + b.getCountOfSeniorCitizens());
                    System.out.println();
                    break;
                case 3:
                    try {
                        System.out.println("Cancel Ticket");
                        System.out.println();
                        System.out.println("Enter Ticket No and Bus No");
                        int tic = sc.nextInt();
                        int busn = sc.nextInt();
                        System.out.println("Whether tickket Cancelled ?: " + b.cancelTicket( busn , tic));

                    } catch (TicketDoesNotPresentException tdee) {
                        System.out.println(tdee);
                    } catch (InvalidBusException ibe) {
                        System.out.println(ibe);
                    }
                    break;
                case 4:
                    System.out.println("Get Passennger By Gender");
                    System.out.println("Enter Gender");
                    String gen = sc.next();
                    List<Passenger> pp = b.getPassengersByGender(gen);
                    for (Passenger k : pp)
                        System.out.println(pp);
                    break;
                case 5:
                    System.out.println("Get Count Of Passenger");
                    System.out.println("");
                    System.out.println("Enter Source and Destination:");
                    String src = sc.next();
                    String desti = sc.next();
                    long l = b.getCountOfPassenger(src, desti);
                    System.out.println();
                    System.out.println("Count of Passenger between the " + src + " and " + desti + ":" + l);
                    break;
                case 6:
                    break;
                default :
                    System.out.println("Invalid Choice");
            }
        } while (ch != 6);
    }
}
