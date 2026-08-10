package service;

import Bean.Feature;
import Bean.Movie;
import Bean.Screen;
import Bean.Theatre;
import Excep.MovieNotFoundException;
import Excep.ScreenNotAvailableException;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class TheatreManagementSystem {
    Scanner sc=new Scanner(System.in);

    List<Theatre> theatre=new ArrayList<>();

  public boolean addTheatreWithScreen(int theatreId, String  name, String address, int noOfScreen, List<Screen> screenList)  {

      if(screenList.size() == noOfScreen)
      {
          Theatre t=new Theatre(theatreId, name, address,noOfScreen, screenList );
          theatre.add(t);
          return true;
      }
      return false;
  }

  public boolean addMovieToTheatre(int theatreId, Movie m)throws ScreenNotAvailableException {
    for(Theatre k: theatre)
    {
        if(theatreId== k.getTheatreId())
        {
            for(Screen s: k.getScreens())
                    if(s.getNoOfDaysRunning()==0) {
                        System.out.println("Enter No of Running Days:");
                        int n=sc.nextInt();
                        s.setNoOfDaysRunning(n);
                        s.setMovie(m);
                        return true;
                    }
            throw new ScreenNotAvailableException("There is no screen available to release the movie");
        }
    }
      return false;
  }

  public boolean dropMovieFromTheatre(int theatreId, Movie m)throws MovieNotFoundException {

      for(Theatre k: theatre){
          if(k.getTheatreId()==theatreId)
          {
             for(Screen s: k.getScreens()) {
                 Movie m1= s.getMovie();
                 if (m1 !=null && m1.getMovieId()==m.getMovieId()) {
                     s.setMovie(null);
                     s.setNoOfDaysRunning(0);
                     return true;
                 }
             }

           throw new MovieNotFoundException("Unable to locate the moviewith specified name");
          }
      }
      return false;
  }

    public List<Movie> listMoviesAvailableInTheatre(){
      List<Movie> l=new ArrayList<>();
      for(Theatre k: theatre){
          for(Screen s: k.getScreens()){
              Movie m=s.getMovie();
              if(m!=null && m instanceof Feature){
                 l.add(m);
              }
          }
      }
      return l;
    }

    public Map<String , Integer> listMoviesCompletedNDays(int numberOfDays){
      Map<String, Integer> h=new HashMap<>();

      for(Theatre k: theatre){
          for(Screen s: k.getScreens()){
             h.put(s.getMovie().getName(), s.getNoOfDaysRunning());
          }
      }

     return h;
    }



}
