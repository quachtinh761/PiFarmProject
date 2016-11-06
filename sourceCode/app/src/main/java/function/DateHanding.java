package function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by vanthi on 11/5/2016.
 */

public class DateHanding {
    static String dateFromat = "dd-MM-yyyy";
    public static boolean isDate(String dateToValidate){

        if(dateToValidate.length() != dateFromat.length()){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {
            //if not valid, it will throw ParseException
            sdf.parse(dateToValidate);
            return true;

        } catch (ParseException e) {
            return false;
        }
    }
    public static Date getDate(String s) throws ParseException {
        if(isDate(s)){
            SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
            sdf.setLenient(false);
            Date date = sdf.parse(s);
            return date;
        }
        else return null;
    }
    public static Date getDateBefore(String date,int nDay ) throws ParseException {
        Calendar calendar= Calendar.getInstance();
        Date d = getDate(date);
        if (d!=null){
            calendar.setTime(d);
            calendar.add(calendar.DATE,-nDay);
            Date resultdate = new Date(calendar.getTimeInMillis());
            return resultdate;
        }
        else return null;
    }
    public static Date getDateBefore(Date date,int nDay ) throws ParseException {
        return getDateBefore(getDateString(date),nDay);
    }
    public static Date getDateAfter(String date,int nDay ) throws ParseException {
        Calendar calendar= Calendar.getInstance();
        Date d = getDate(date);
        if (d!=null){
            calendar.setTime(d);
            calendar.add(calendar.DATE,nDay);
            Date resultdate = new Date(calendar.getTimeInMillis());
            return resultdate;
        }
        else return null;
    }
    public static Date getDateAfter(Date date,int nDay ) throws ParseException {
        return getDateAfter(getDateString(date),nDay);
    }
    public static String getDateString(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        return sdf.format(d);
    }
}