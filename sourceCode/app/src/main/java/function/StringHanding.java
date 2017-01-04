package function;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by vanthi on 10/28/2016.
 */
/* this String is: $abc#cde#cdc$
    This class use for processing type string predefined by GANT
*/
public class StringHanding {

    private static String listIgnoreChar = "#$'";
    //convert from $abc#cde#cdc$ to array String
    public static String[] getArrayStr(String str) {
        if (str.equals("")) return null;
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
                if (temp[i] + 1 == temp[i + 1]) buf[i] = "";
                else buf[i] = str.substring(temp[i] + 1, temp[i + 1]);
            }
            return buf;
        } else return null;
    }

    public static List<String> getListStr(String str){
        List<String> ls = new LinkedList<>();
        String temp[] = getArrayStr(str);
        for (int i = 0; i < temp.length; i++){
            ls.add(temp[i]);
        }
        return ls;
    }

    //convert from array string to $abc#cde#cdc$
    public static String getStr(String[] list) {
        if (list == null) return "";
        String temp = "$";
        for (String val : list) {
            if (val != "") temp = temp + val + "#";
            else temp += "#";
        }
        String p = temp.substring(0, temp.length() - 1);
        p += "$";
        return p;
    }

    //convert from list string to $abc#cde#cdc$
    public static String getStr(List<String> list) {
        if (list.isEmpty()) return "";
        String temp = "$";
        for (String val : list) {
            if (val != "") temp = temp + val + "#";
            else temp += "#";
        }
        String p = temp.substring(0, temp.length() - 1);
        p += "$";
        return p;
    }

    //convert from array field and array value to array type $field#value$
    public static String[] getArrayListStr(List<String[]> data) {
        if (data.isEmpty()) return null;
        String[] temp = new String[data.size()];
        int i = 0;
        for (String[] var : data) {
            temp[i] = getStr(var);
            i++;
        }
        return temp;
    }
    /*public static String[] setStrProcess(String[] field,String[] value){
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
    public static String[] setStrProcess(List<String> field,List<String> value){
        if (field.size() != value.size()) return null;
        String[] temp = new String[field.size()];
        String[] p = new String[2];
        for (int i=0;i<field.size();i++){
            p[0] = field.get(i);
            p[1] = value.get(i);
            temp[i] = setStrProcess(p);
        }
        return temp;
    }*/

    //check String method

    //check is valid string: it's String that hasn't special character ($,#,...)
    public static Boolean isValidString(String s){
        for (int i=0;i<s.length();i++) {
            for (int j=0;j<listIgnoreChar.length();j++)
                if (s.charAt(i) == listIgnoreChar.charAt(j) || s.charAt(i) == 34 || s.charAt(i) == 92) return false;
        }
        return true;
    }
    //check is valid phone number: phone number must more than 9 char (can start 0 or +(area number))
    public static Boolean isValidPhone(String phoneNum){
        if (phoneNum.length() <= 9 ) return false;
        if (!(phoneNum.startsWith("+") || phoneNum.startsWith("0"))){
            return false;
        }
        for (int i=1;i<phoneNum.length();i++){
            if (phoneNum.charAt(i) < '0' || phoneNum.charAt(i) > '9') return false;
        }
        return true;
    }
    //auto fix unvalid string to valid string
    //exam string is "cddvdv#$" -> "cddvdv"
    public static String getValidString(String s){
        if (isValidString(s)) return s;
        else{
            for (int i=0;i<s.length();i++) {
                for (int j=0;j<listIgnoreChar.length();j++)
                    if (s.charAt(i) == listIgnoreChar.charAt(j) || s.charAt(i) == 34 || s.charAt(i) == 92) {
                        s = s.substring(0,i) + s.substring(i+1);
                        break;
                    }
            }
            return s;
        }
    }

    //you hava data $dfd#sdfd#dsfd$ you can add to this data some value
    // exam: you can add abc to $dfd#sdfd#dsfd$ -> $dfd#sdfd#dsfd#abc$
    //if data is null ("") this method will create for you data type $dataadd$
    public static String add(String data,String dataNeedAdd){
        if (data.equals("")) {
            data = "$" + dataNeedAdd +"$";
            return data;
        }
        if(data.equals("$$")){
            data = "$#" + dataNeedAdd +"$";
            return data;
        }
        String temp = data.substring(0,data.length()-1);
        temp = temp + "#" + dataNeedAdd + "$";
        return temp;
    }
    //get size data: $fsdf#adfd#dsd$ -> 3
    // $Wsdd#$ -> 2
    //$$-> 1 (have value but value is null
    //"" ->0
    public static int size(String data){
        int count = 0;
        if (data.startsWith("$") && data.endsWith("$")) {
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '#') count++;
            }
            count++;
        }
        return count;
    }

    //get data at index
    public static String getAt(String data,int index){
        int count = 0;
        List<Integer> indexStart = new ArrayList<Integer>();
        indexStart.add(1);
        if (data.startsWith("$") && data.endsWith("$")) {
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '#') {
                    count++;
                    indexStart.add(i+1);
                }
            }
            count++;
        }
        indexStart.add(data.length());
        if (index < 0 || index > count-1 ) return "";
        String temp = data.substring(indexStart.get(index),indexStart.get(index+1)-1);
        return temp;
    }

    public static String getFirst(String data){
        return getAt(data,0);
    }
    public static String getLast(String data){
        return getAt(data,size(data)-1);
    }

    //return 2number string (use for number swineChild)
    public static String parseTwoNumber(int i){
        if ( i < 0 || i > 99 ){
            return "";
        }
        else if (i < 10) return "0" + String.valueOf(i);
        else return String.valueOf(i);
    }
}
