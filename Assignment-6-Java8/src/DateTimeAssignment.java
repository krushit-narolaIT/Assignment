import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;

public class DateTimeAssignment {
    public static void main(String[] args) {
        /*Q1. Create a program to calculate the number of days until your next birthday.*/
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2003, 10, 18);

        if (today.isAfter(birthday)) {
            int diffYear = today.getYear() - birthday.getYear();
            birthday = birthday.plusYears(diffYear);
        }

        Period period = Period.between(today, birthday);
        System.out.println("Your Birthday in " + period.getMonths() + " Months " + period.getDays() + " Days");

        /*Q2. Format the current date and time into a custom pattern (e.g., MM/dd/yyyy HH:mm).*/
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        System.out.println("Formatted Date&Time: " + now.format(formatter));

        /*Q3. Find the difference in hours between two time zones (e.g., UTC and Asia/Kolkata).*/
        LocalDateTime utc = LocalDateTime.now(ZoneId.of("UTC"));
        LocalDateTime kolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

//        long hoursDifference = ChronoUnit.HOURS.between(utc, kolkata);
//        System.out.println("Difference in hours: " + hoursDifference);
    }
}
