
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    private static final String startWorldDate = "01/01/2019 00:00:00";

// This function gives the hours elapsed for the input date since 1st January 2019
    public int  getHoursElapsed(String endDateString){
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        int elapsedHours = 0;

        try {

            Date startDate = simpleDateFormat.parse(startWorldDate);
            Date endDate = simpleDateFormat.parse(endDateString);

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();


        int secondsInMilli = 1000;
        int minutesInMilli = secondsInMilli * 60;
        int hoursInMilli = minutesInMilli * 60;

         elapsedHours = (int)different / hoursInMilli;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return elapsedHours;

    }

    // This function gives the hours elapsed for the current time since 1st January 2019
    public  int getCurrentHoursElapsed() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String formattedDate= simpleDateFormat.format(date);
        return getHoursElapsed(formattedDate);

    }

}
