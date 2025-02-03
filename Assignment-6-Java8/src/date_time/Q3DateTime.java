package date_time;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/*Q3. Find the difference in hours between two time zones (e.g., UTC and Asia/Kolkata).*/
public class Q3DateTime {
    public static void main(String[] args) {
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
