package Test;

import Bean.*;
import Excep.TournamentAlreadyExist;
import Service.AthleteManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int t_id = 1234;
    static int s_id = 7800;

    public static <Sport> void main(String[] args) {
        AthleteManagement am = new AthleteManagement();
        Scanner sc = new Scanner(System.in);
        int ch;

        String gameType,s_name;

        do {
            System.out.println("Athlete Management System");
            System.out.println("1-----> Add New Tournament");
            System.out.println("2-----> UpdateTournamentStatus");
            System.out.println("3-----> Retrive Sports");
            System.out.println("4-----> Find Participant Count");
            System.out.println("5----->Get All Players With Experience");
            System.out.println("6----->Exit");
            System.out.println("Enter ur Choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        System.out.println("Add New Tournament");
                        System.out.println();
                        System.out.println("Enter Tournament Details:-");
                        System.out.println("Enter the Start Date of The tournament(yyyy-mm-dd):");
                        String ss = sc.next();
                        LocalDate s_date = LocalDate.parse(ss);
                        System.out.println("Enter Tournament End Date(yyyy-mm-dd):");
                        LocalDate e_date = LocalDate.parse(sc.next());
                        System.out.println();

                        List<Sports> spo = new ArrayList<>();// Sports array
                        System.out.println("Enter no of Sports:");
                        int n_sports = sc.nextInt();
                        for (int i = 0; i < n_sports; i++) {
                            System.out.println("Enter Sport Details");
                         /*
                        System.out.println("Enter Sports Name:");
                        String s_name = sc.next();
                       System.out.println("Enter gameType :\n1-->Indoor\n2-->OutDoor");
                        int in = sc.nextInt();
                        if (in == 1)
                            gameType = "Indoor";
                        else
                            gameType = "Outdoor";*/
                            System.out.println("Enter sport name\n1-->Tennis\n2--Chess");
                            int ty = sc.nextInt();
                            System.out.println("Enter n of Players in sport" + (i + 1) + ":");
                            int np = sc.nextInt();

                            List<Player> pp = new ArrayList<>(); //player
                            for (int j = 0; j < np; j++) {
                                System.out.println("Enter Details of Player " + (j + 1) + ": ");
                                System.out.println("Enter Name : ");
                                String name = sc.next();
                                System.out.println("Enter age:");
                                int age = sc.nextInt();
                                System.out.println("Enter Experience (No of Years):");
                                int experience = sc.nextInt();
                                System.out.println("Enter Qualification: ");
                                String qualification = sc.next();
                                Player p = new Player(name, age, experience, qualification);
                                pp.add(p);
                            }

                            if (ty == 1) {
                                s_name = "Tennis";
                                Tennis t = new Tennis(s_id++, "Tennis", "OutDoor", null, pp);
                                spo.add(t);
                            } else {
                                s_name = "Chess";
                                Chess c = new Chess(s_id++, "Chess", "InDoor", null, pp);
                                spo.add(c);
                            }
                            System.out.println("SportId: " + (s_id - 1));
                            System.out.println();
                        }
                        System.out.println("Tournament Id:" + (t_id - 1));
                        System.out.println();
                        TournamentDetails td = new TournamentDetails(t_id, s_date, e_date, spo);
                        am.addNewTournament(td);
                        System.out.println();
                    }catch(TournamentAlreadyExist tae){
                        System.out.println(tae);
                    }
                    break;
                case 2:
                    System.out.println("Update Tourament Status -Announce Winner :-");
                    System.out.println("Winner Id and SportID:");
                    System.out.println("Enter Tournamnet ID:");
                    int id = sc.nextInt();
                    System.out.println("Enter Sport ID:");
                    int sid = sc.nextInt();
                    System.out.println("Whether Wninner Updated ?: " + am.updateTournamentStatus(id, sid, "Yes"));
                    System.out.println();
                    break;
                case 3:

                    System.out.println("Retrive Sports Where Winner is not Dclared:-");
                    System.out.println();
                    System.out.println("Enter Tournament Id:");
                    sid = sc.nextInt();
                    List<Sports> sp_list = am.retriveSports(sid);
                    sp_list.stream().forEach(System.out::println);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Find Participant Count :-");
                    System.out.println("Enter SportId:");
                    sid = sc.nextInt();
                    System.out.println("Count of Participant in the SportID (" + sid + ") is " + am.findParticipationCount(sid));
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Get Players who has Experience:-");
                    System.out.println();
                    System.out.println("Enter Experience:");
                    sid = sc.nextInt();
                    List<Player> pl = am.getAllPlayerwithExperience(sid);
                    System.out.println();
                    break;

            }
        }while (ch != 6) ;


    }
}

