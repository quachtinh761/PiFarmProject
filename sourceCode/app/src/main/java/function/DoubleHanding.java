package function;

import java.text.ParseException;

/**
 * Created by vanthi on 11/5/2016.
 */

public class DoubleHanding {
    public static Boolean isDouble(String s){
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    public static double getDouble(String s){
        if (isDouble(s)) return Double.parseDouble(s);
        else return 0;
    }
}
