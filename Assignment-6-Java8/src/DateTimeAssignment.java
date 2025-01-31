import java.time.*;
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
        ZoneId utcZone = ZoneId.of("UTC");
        ZoneId kolkataZone = ZoneId.of("Asia/Kolkata");

        ZoneOffset utcOffset = ZonedDateTime.now(utcZone).getOffset();
        ZoneOffset kolkataOffset = ZonedDateTime.now(kolkataZone).getOffset();

        int differenceInSeconds = kolkataOffset.getTotalSeconds() - utcOffset.getTotalSeconds();

        int hours = differenceInSeconds / 3600;
        int minutes = (differenceInSeconds % 3600) / 60;

        System.out.println("Time difference between UTC and Asia/Kolkata: " + hours + " hours " + minutes + " minutes");
    }
}
