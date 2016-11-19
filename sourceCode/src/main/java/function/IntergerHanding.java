package function;

/**
 * Created by vanthi on 11/5/2016.
 */

public class IntergerHanding {
    public static boolean isInterger(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static int getInterger(String s){
        if (isInterger(s)) return Integer.parseInt(s);
        else return 0;
    }
}
