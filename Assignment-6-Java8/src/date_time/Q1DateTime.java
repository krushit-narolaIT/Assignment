package date_time;

import java.time.LocalDate;
import java.time.Period;

/*Q1. Create a program to calculate the number of days until your next birthday.*/
public class Q1DateTime {
    public static void main(String[] args) {
        //get current time
        LocalDate today = LocalDate.now();
        //get birthdate
        LocalDate birthday = LocalDate.of(2003, 10, 18);

        //calculate age by diffyear and then add it to birthday
        if (today.isAfter(birthday)) {
            int diffYear = today.getYear() - birthday.getYear();
            birthday = birthday.plusYears(diffYear);
        }

        //calculate period between today & birthday
        Period period = Period.between(today, birthday);
        System.out.println("Your Birthday in " + period.getMonths() + " Months " + period.getDays() + " Days");
    }
}
