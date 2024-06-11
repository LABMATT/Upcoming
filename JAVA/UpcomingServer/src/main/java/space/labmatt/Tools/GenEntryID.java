package space.labmatt.Tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// An Idea is the gen using day-month-year_hour-minutes-seconds
public class GenEntryID {

    public String GenrateID() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy_HHMMSS");

        LocalDateTime localDateTime = LocalDateTime.now();

        return dateTimeFormatter.format(localDateTime);
    }


    // Gets the current year for folder storage
    public String folderDate() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");

        LocalDateTime localDateTime = LocalDateTime.now();

        return dateTimeFormatter.format(localDateTime);
    }
}
