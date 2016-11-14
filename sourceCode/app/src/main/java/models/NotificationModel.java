package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import objects.NotificationObject;


public class NotificationModel extends BaseModel {
    private String tableName = "NOTIFICATION";
    private List<String []> params;
    private static String[] listFieldArr = {"Date","Notification"};

    private void makeparams(){
        String[] p = new String[2];
        p[0] = listFieldArr[0];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = listFieldArr[1];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public NotificationModel() {
        if (!this.isTableExist(tableName)){
            makeparams();
            this.createTable(tableName,params);
        }
    }

    private Map<String, String> makeMap(NotificationObject notificationObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listFieldArr[0],DateHanding.getDateString(notificationObject.getDate()));
        map.put(listFieldArr[1],notificationObject.getNotification());
        return map;
    }
    public void add(NotificationModel notificationModel){
        this.insertTable(tableName,makeMap(notificationModel));
    }

}
