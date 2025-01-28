import java.time.LocalDate;
import java.time.Period;

public class DaysUntilBirthday {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2003, 10, 18);

        if (today.isAfter(birthday)) {
            int diffYear = today.getYear() - birthday.getYear();
            birthday = birthday.plusYears(diffYear);
        }

        Period period = Period.between(today, birthday);
        System.out.println("Your Birthday in " + period.getMonths() + " Months " + period.getDays() + " Days");
    }
}