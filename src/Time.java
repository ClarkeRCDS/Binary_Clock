//time import
import java.time.LocalTime;
public class Time {

    //these variables hold the value of the second, minute, and hour from the current time
    private static int second;
    private static int minute;
    private static int hour;
    private static boolean AM;

    //constructor
    public Time()
    {

    }

    //gets the most recent time
    private static LocalTime getTime()
    {
       return LocalTime.now(java.time.ZoneId.of("America/New_York"));
    }

    //updates the variables based on the most recent time
    public static void updateTime() {
        LocalTime time = getTime();
        second = time.getSecond();
        minute = time.getMinute();
        hour = time.getHour();
        //converts to a 12 hour clock
        if (hour > 12) {
            hour = hour - 12;
            AM = false;
        } else
        {
            AM = true;
        }
    }
    //converts from the time integer to binary string
    private static String BinConvert(int time) {
        //holds value that number will be subtracted by
        int binCt = 1;
        String timeBin = "";
        while(time - binCt >=0){
            binCt *= 2;
        }
        binCt /= 2;
        //this loop adds the ones and zeros to the binary number until it reaches zero
        //a one is added if the result of binCt subtraction
        //is positive and a zero is added if the result is negative
        while(binCt > 0){
            if(time - binCt >= 0){
                timeBin = timeBin + "1";
                time -= binCt;
            }else{
                timeBin = timeBin + "0";
            }
            //divides binCt so the number gets halved after each subtraction
            binCt/=2;
        }
        while (timeBin.length() != 6){
            timeBin = "0" + timeBin;
        }
       return timeBin;
    }

    //gets the binary time
    public static String getBinSecond()
    {
        return BinConvert(second);
    }
    public static String getBinMinute()
    {
        return BinConvert(minute);
    }
    public static String getBinHour()
    {
        return BinConvert(hour);
    }

    public static Boolean getAM()
    {
        return AM;
    }
}


