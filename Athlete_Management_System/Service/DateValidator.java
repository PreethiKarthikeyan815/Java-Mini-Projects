package Service;

import java.time.LocalDate;
import java.util.Date;

public class DateValidator {

    public boolean validateDate(LocalDate tournamentStartDate , LocalDate tournamentEndDate )
    {

              LocalDate d1 = tournamentStartDate;
               LocalDate d2=tournamentEndDate;
           return d1.isBefore(d2);
    }
}
