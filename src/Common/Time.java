package Common;


import java.io.Serializable;
import java.time.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Time implements Serializable {
    /**
     * this class uses for getting right time
     */
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * this method returns now time
     * @return
     */
    public static String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public static Long getMilli(){
        return Instant.now().toEpochMilli();
    }
}
