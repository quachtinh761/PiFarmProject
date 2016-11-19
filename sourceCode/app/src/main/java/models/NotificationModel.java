package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
    private static String[] listField = {"Date","Notification"};
    private void createTableNotification(){
        List<String []> params= new ArrayList<>();
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = listField[1];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        this.createTable(tableName,params);
    }

    public NotificationModel(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.createTableNotification();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */

    public void add(){
        Map<String, String> map = new HashMap<String, String>();
        //map.put(listField[0],DateHanding.getDateString(notificationObject.getDate()));
        //map.put(listField[1],notificationObject.getNotification());
        map.put(listField[0],"12-13-1415");
        map.put(listField[1],"okokok");
        this.insert(tableName,map);
    }

    public void remove(List<NotificationObject> notificationObjects){
        Map<String, String> map = new HashMap<String, String>();
        for (NotificationObject var : notificationObjects) {
            map.put(listField[0],DateHanding.getDateString( var.getDate()));
            this.deleteRecord(tableName, map);
            map.clear();
        }
    }
    public List<String[]> getNotificationByDate(String date){
        String whereClause = listField[0]+" = ?";
        String[] whereArgs = new String[]{date};
        return this.searchDataByConditions(tableName, new String[]{"*"}, whereClause, whereArgs, null, null, null);
    }

}
