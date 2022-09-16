package org.mja123.appiumPractice.android.builtIn.clock.dateUtils;

import java.util.Calendar;

public class DateFormat {
    public static String dateFormatter() {

        String day = currentDayOfWeek();
        String month = currentMonth();
        String number = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        return day + ", " + month + " " + number;
    }

    private static String currentMonth() {
        return switch (Calendar.getInstance().get(Calendar.MONTH)) {
            case Calendar.JANUARY -> "Jan";
            case Calendar.FEBRUARY -> "Feb";
            case Calendar.MARCH -> "Mar";
            case Calendar.APRIL -> "Apr";
            case Calendar.MAY -> "May";
            case Calendar.JUNE -> "Jun";
            case Calendar.JULY -> "Jul";
            case Calendar.AUGUST -> "Aug";
            case Calendar.SEPTEMBER -> "Sep";
            case Calendar. OCTOBER -> "Oct";
            case Calendar.NOVEMBER -> "Nov";
            default -> "Dec";
        };
    }

    private static String currentDayOfWeek() {
        return switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY -> "Mon";
            case Calendar.TUESDAY -> "Tue";
            case Calendar.WEDNESDAY -> "Wed";
            case Calendar.THURSDAY -> "Thu";
            case Calendar.FRIDAY -> "Fry";
            case Calendar.SATURDAY -> "Sat";
            default -> "San";
        };
    }
}
