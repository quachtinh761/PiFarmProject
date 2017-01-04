package models;

import android.content.Context;
import android.os.NetworkOnMainThreadException;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import function.IntergerHanding;
import objects.NotificationObject;


public class NotificationModel extends BaseModel {
    private String tableName = "NOTIFICATION";
    private List<String []> params;
    private static String[] listField = { "Type" , "Duedate" , "Content" , "HaveDone" , "cardID" };

    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "INTEGER NOT NULL";
        params.add(p);

        String[] p1 = new String[2];
        p1[0] = listField[1];
        p1[1] = "TEXT(10) NOT NULL";
        params.add(p1);

        String[] p2 = new String[2];
        p2[0] = listField[2];
        p2[1] = "TEXT(256) NOT NULL";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[3];
        p3[1] = "INTEGER";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[4];
        p4[1] = "TEXT(10)";
        params.add(p4);
    }

    public NotificationModel(Context context) {
        super(context);
        if (!this.isTableExist(tableName)){
            makeparams();
            this.createTable(tableName,params);
        }
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */

    private Map<String, String> makeMap(NotificationObject notificationObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0],notificationObject.getType() + "");
        map.put(listField[1], DateHanding.getDateString(notificationObject.getDuedate()));
        map.put(listField[2], notificationObject.getContent());
        map.put(listField[3], notificationObject.isHaveDone() ? "1" : "0");
        map.put(listField[4], notificationObject.getCardID());
        return map;
    }
    public void add(NotificationObject notificationObject){
        this.insert(tableName, makeMap(notificationObject));
    }
    public void add(List<NotificationObject> notificationObjects){
        for (NotificationObject var: notificationObjects) add(var);
    }
    public void remove(String cardID){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[4],cardID);
        this.deleteRecord(tableName, map);
        map.clear();
    }
    public void remove(List<NotificationObject> notificationObjects){
        for ( NotificationObject not : notificationObjects) remove (not);
    }

    public void remove(NotificationObject notificationObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[4], notificationObject.getCardID());
        this.deleteRecord(tableName, map);
        map.clear();
    }

    //num is index of listField
    public List<NotificationObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(IntergerHanding.getInterger(var[0]), DateHanding.getDate(var[1]), var[2], var[3].equals("1") ? true : false, var[4]));
        }
        return p;
    }
    public List<NotificationObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[]{needSearch},"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(IntergerHanding.getInterger(var[0]), DateHanding.getDate(var[1]), var[2], var[3].equals("1") ? true : false, var[4]));
        }
        return p;
    }
    public List<NotificationObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(IntergerHanding.getInterger(var[0]), DateHanding.getDate(var[1]), var[2], var[3].equals("1") ? true : false, var[4]));
        }
        return p;
    }
    public List<NotificationObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(IntergerHanding.getInterger(var[0]), DateHanding.getDate(var[1]), var[2], var[3].equals("1") ? true : false, var[4]));
        }
        return p;
    }

    public List<NotificationObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(IntergerHanding.getInterger(var[0]), DateHanding.getDate(var[1]), var[2], var[3].equals("1") ? true : false, var[4]));
        }
        return p;
    }
}
