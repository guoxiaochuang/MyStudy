package com.guo.time;

public class DateUtils {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";

    public DateUtils() {
    }

    public static Date dateAdd(Date date, int days, boolean includeTime) throws ParseException {
        if (date == null) {
            date = new Date();
        }

        if (!includeTime) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(sdf.format(date));
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static String dateFormat(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String getDateString(Date date) {
        try {
            return dateFormat(date, "yyyy-MM-dd");
        } catch (Exception var2) {
            return "";
        }
    }

    public static String getDateTimeString(Date date) {
        try {
            return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception var2) {
            return "";
        }
    }

    public static Date dateParse(String dateTimeString, String pattern) throws ParseException {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTimeString);
    }

    public static String dateTimeToDateString(Date dateTime) throws ParseException {
        String dateTimeString = dateFormat(dateTime, "yyyy-MM-dd HH:mm:ss");
        return dateTimeString.substring(0, 10);
    }

    public static String dateTimeToDateStringIfTimeEndZero(Date dateTime) throws ParseException {
        String dateTimeString = dateFormat(dateTime, "yyyy-MM-dd HH:mm:ss");
        return dateTimeString.endsWith("00:00:00") ? dateTimeString.substring(0, 10) : dateTimeString;
    }

    public static Date dateTimeToDate(Date dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date dateAddHours(Date startDate, int hours) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(10, c.get(10) + hours);
        return c.getTime();
    }

    public static Date dateAddMinutes(Date startDate, int minutes) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(12, c.get(12) + minutes);
        return c.getTime();
    }

    public static Date dateAddSeconds(Date startDate, int seconds) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(13, c.get(13) + seconds);
        return c.getTime();
    }

    public static Date dateAddDays(Date startDate, int days) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(5, c.get(5) + days);
        return c.getTime();
    }

    public static Date dateAddMonths(Date startDate, int months) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(2, c.get(2) + months);
        return c.getTime();
    }

    public static Date dateAddYears(Date startDate, int years) {
        if (startDate == null) {
            startDate = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(1, c.get(1) + years);
        return c.getTime();
    }

    public static int dateCompare(Date myDate, Date compareDate) {
        Calendar myCal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        myCal.setTime(myDate);
        compareCal.setTime(compareDate);
        return myCal.compareTo(compareCal);
    }

    public static Date dateMin(Date date, Date compareDate) {
        if (date == null) {
            return compareDate;
        } else if (compareDate == null) {
            return date;
        } else if (1 == dateCompare(date, compareDate)) {
            return compareDate;
        } else {
            return -1 == dateCompare(date, compareDate) ? date : date;
        }
    }

    public static Date dateMax(Date date, Date compareDate) {
        if (date == null) {
            return compareDate;
        } else if (compareDate == null) {
            return date;
        } else if (1 == dateCompare(date, compareDate)) {
            return date;
        } else {
            return -1 == dateCompare(date, compareDate) ? compareDate : date;
        }
    }

    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        Date dateStart = dateParse(dateFormat(startDate, "yyyy-MM-dd"), "yyyy-MM-dd");
        Date dateEnd = dateParse(dateFormat(endDate, "yyyy-MM-dd"), "yyyy-MM-dd");
        return (int)((dateEnd.getTime() - dateStart.getTime()) / 1000L / 60L / 60L / 24L);
    }

    public static int dateBetweenIncludeToday(Date startDate, Date endDate) throws ParseException {
        return dateBetween(startDate, endDate) + 1;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(1);
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(2) + 1;
    }

    public static int getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(5);
    }

    public static int getDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(5);
    }

    public static int getDaysOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(6);
    }

    public static Date maxDateOfMonth(Date date) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int value = cal.getActualMaximum(5);
            return dateParse(dateFormat(date, "yyyy-MM") + "-" + value, (String)null);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date minDateOfMonth(Date date) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int value = cal.getActualMinimum(5);
            return dateParse(dateFormat(date, "yyyy-MM") + "-" + value, (String)null);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date formatStringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse(date);
        } catch (ParseException var3) {
            var3.printStackTrace();
            throw new RuntimeException(var3.toString());
        }
    }

    public static Date formatStringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(date);
        } catch (ParseException var4) {
            var4.printStackTrace();
            throw new RuntimeException(var4.toString());
        }
    }

    public static Date getEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static Date getHourDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }
}
