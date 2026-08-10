package TheatreManagementTester;

import Bean.Documentary;
import Bean.Feature;
import Bean.Movie;
import Bean.Screen;
import Excep.MovieNotFoundException;
import Excep.ScreenNotAvailableException;
import service.TheatreManagementSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        TheatreManagementSystem tms=new TheatreManagementSystem();

        int ch;


        do{
            System.out.println("Theatre Management System");
            System.out.println("1-----> Add Theatre with screen ");
            System.out.println("2-----> Add Movie To The Theatre");
            System.out.println("3-----> Drop Movie From Theatre");
            System.out.println("4-----> List of Movies Completed N Days");
            System.out.println("5-----> Movies Available in Theatre");
            System.out.println("Enter Your choice:");
            ch=sc.nextInt();

            switch (ch){
                case 1:
                    System.out.println("Add Theatre with Screen");
                    System.out.println("Enter Theatre name:");
                    String  t_name=sc.next();
                    System.out.println("Enter Theatre ID:");
                    int id=sc.nextInt();
                    System.out.println("Enter Theatre Address:");
                    String t_address=sc.next();
                    System.out.println("Enter no Of Screens present in Theatre: ");
                    int no_tscreen=sc.nextInt();
                    System.out.println("Enter no Of Screen to Add in the theatre:");
                    int n=sc.nextInt();
                    List<Screen> screenList = new ArrayList<>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println("Details of screen"+(i+1)+":");
                        System.out.println("Enter ScreenId: ");
                        int id_screen=sc.nextInt();
                        System.out.println("Enter Screen name:");
                        String name=sc.next();
                        System.out.println("Enter width of screen:");
                        int width=sc.nextInt();
                        System.out.println("Enter height of Screen:");
                        int height=sc.nextInt();
                        System.out.println("Enter noOfDaysRunning:");
                        int no=sc.nextInt();
                        System.out.println("Enter noOfShows: ");
                        int no_show =sc.nextInt();
                        Movie m=null;
                        Screen s =new Screen(id_screen, name, width, height, no, no_show, m);
                        screenList.add(s);
                    }
                    System.out.println("Whether the Theatre is Added with the Screen? : "+ tms.addTheatreWithScreen(id, t_name, t_address, no_tscreen, screenList));
                    break;
                case 2:
                    try {
                        System.out.println("Add Movie To The Theatre");
                        System.out.println("Enter TheatreId:");
                        id = sc.nextInt();
                        System.out.println("Enter Movie Details:- ");
                        System.out.println("Enter MovieID: ");
                        int mov_id = sc.nextInt();
                        System.out.println("Enter Name: ");
                        String name = sc.next();
                        System.out.println("Enter Language: ");
                        String lang = sc.next();
                        System.out.println("Enter Director name:");
                        String d_name = sc.next();
                        System.out.println("Enter Duration of Movie :");
                        double duration = sc.nextDouble();
                        //Movie movie= new Movie()
                        System.out.println("Enter Type of Movie:\n1--->Documentary\n2--->Feature");
                        int type = sc.nextInt();
                        System.out.println("Enter Type/Topic Of Movie:");
                        String typ = sc.next();
                        if (type == 1) {
                            Documentary d = new Documentary(mov_id, name, lang, d_name, duration, typ);
                            System.out.println("Whether Movie AddedTo the Theatre: " + tms.addMovieToTheatre(id, d));
                        } else {
                            Feature f = new Feature(mov_id, name, lang, d_name, duration, typ);
                            System.out.println("Whether Movie AddedTo the Theatre: " + tms.addMovieToTheatre(id, f));
                        }
                    }catch(ScreenNotAvailableException sce){
                        System.out.println(sce);
                    }
                   break;
                case 3:
                    try {
                        System.out.println("Drop Movie From Theatre :");
                        System.out.println("Enter TheatreId:");
                        id = sc.nextInt();

                        System.out.println("Enter Movie Details:- ");
                        System.out.println("Enter MovieID: ");
                        int mov_id = sc.nextInt();
                    /*
                    System.out.println("Enter Name: ");
                    String name = sc.next();
                    System.out.println("Enter Language: ");
                    String lang= sc.next();
                    System.out.println("Enter Director name:");
                    String d_name=sc.next();
                    System.out.println("Enter Duration of Movie :");
                    double duration= sc.nextDouble();
                    System.out.println("En");
                   */
                        Movie m1 = new Movie(mov_id, null, null, null, 0);
                        System.out.println("Whether Movie Droped from Theatre? : " + tms.dropMovieFromTheatre(id, m1));
                    }catch(MovieNotFoundException mnfe){
                        System.out.println(mnfe);
                    }
                    break;
                case 4:
                    System.out.println("Movies Completed N No Of Days:");
                    System.out.println("Enter Movies which Completed N No Of Days:");
                    int N= sc.nextInt();
                    Map<String , Integer> map= tms.listMoviesCompletedNDays(N);
                    //map.size().forEach(k-> System.out.println("Movies Completed "+N+" Days:\n"+k+"\n"));
                    for(Map.Entry<String , Integer> mm : map.entrySet())
                        System.out.println("Movie Name: "+mm.getKey()+"   No Of Days: "+ mm.getValue());
                    break;
                case 5:
                    System.out.println("List Of Movies Available in Theatre");
                    List<Movie> m2= tms.listMoviesAvailableInTheatre();
                    m2.stream().forEach(k-> System.out.println("List Of Movies Present in Theatre:\n"+k+"\n"));
                    break;
                case 6:
                    break;

            }
        }while(ch!=6);
    }
}
