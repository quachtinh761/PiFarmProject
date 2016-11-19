package models;

import android.content.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import function.IntergerHanding;
import objects.NotificationObject;
import objects.ParentProcessObject;


public class NotificationModel extends BaseModel {
    private String tableName = "NOTIFICATION";
    private List<String []> params;
    private static String[] listField = {"Date","Notification"};

    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = listField[1];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
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
        map.put(listField[0],DateHanding.getDateString(notificationObject.getDate()));
        map.put(listField[1],notificationObject.getNotification());
        return map;
    }
    public void add(NotificationObject notificationObject){
        this.insert(tableName,makeMap(notificationObject));
    }

    public void remove(List<NotificationObject> notificationObjects){
        Map<String, String> map = new HashMap<String, String>();
        for (NotificationObject var : notificationObjects) {
            map.put(listField[0],DateHanding.getDateString( var.getDate()));
            this.deleteRecord(tableName, map);
            map.clear();
        }
    }
    public List<NotificationObject> search(String[] date){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0],date,"","","");
        List<NotificationObject> p = new LinkedList<NotificationObject>();
        for (String[] var: buff) {
            p.add(new NotificationObject(DateHanding.getDate(var[0]),var[1]));
        }
        return p;
    }
    public List<NotificationObject> search(Date[] date){
        String[] lsDate = new String[date.length];
        for (int i=0; i < date.length; i++){
            lsDate[i] = DateHanding.getDateString(date[i]);
        }
        return  search(lsDate);
    }

}
