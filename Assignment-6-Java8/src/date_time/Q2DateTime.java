package date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Q2. Format the current date and time into a custom pattern (e.g., MM/dd/yyyy HH:mm).*/
public class Q2DateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        System.out.println("Formatted Date&Time: " + now.format(formatter));
    }
}
