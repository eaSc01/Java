import java.util.*;

public class Cal {
    public static String findDay(int month, int day, int year) {

        Calendar cal = Calendar.getInstance();          // creates calender instance initialized to actual date and time.

        cal.set(Calendar.MONTH,month-1);        // set method changes, get method returns
        cal.set(Calendar.DATE,day);
        cal.set(Calendar.YEAR,year);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();    // LONG stands for long style, eg SUNDAY, SHORT stands for short style, eg SUN
    
    }

    public static void main(String args[]) {
        System.out.println( findDay(11, 2, 2023));
        
    }
}
