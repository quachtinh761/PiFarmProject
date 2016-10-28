package function;

/**
 * Created by vanthi on 10/28/2016.
 */
/* this String is: $abc#cde#cdc$
    This class use for processing type string predefined by GANT
*/
public class processStringPredefined {
    //convert from $abc#cde#cdc$ to array String
    public static String[] getStrProcess(String str) {
        if (str == null) return null;
        int m = 1;
        int p = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') p++;
        }
        String[] buf = new String[p];
        int[] temp = new int[p + 1];
        temp[0] = 0;
        temp[p] = str.length() - 1;
        if (str.startsWith("$") && str.endsWith("$")) {
            for (int i = 1; i < str.length() - 1; i++) {
                if (str.charAt(i) == '#') {
                    temp[m] = i;
                    m++;
                }
            }
            for (int i = 0; i < p; i++) {
                if (temp[i] + 1 == temp[i + 1]) buf[i] = null;
                else buf[i] = str.substring(temp[i] + 1, temp[i + 1]);
            }
            return buf;
        }else return null;
    }
    //convert from array string to $abc#cde#cdc$
    public static String setStrProcess(String[] list){
        if (list == null) return null;
        String temp = "$";
        for (String val: list) {
            if (val!=null) temp = temp+val+"#";
            else temp += "#";
        }
        String p = temp.substring(0,temp.length()-1);
        p+="$";
        return p;
    }
    //convert from array field and array value to array type $field#value$
    public static String[] setStrProcess(String[] field,String[] value){
        if (field.length != value.length) return null;
        String[] temp = new String[field.length];
        String[] p = new String[2];
        for (int i=0;i<field.length;i++){
            p[0] = field[i];
            p[1] = value[i];
            temp[i] = setStrProcess(p);
        }
        return temp;
    }
}
