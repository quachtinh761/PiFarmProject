package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import function.IntergerHanding;
import objects.ChildObject;

/**
 * Created by Van Thi on 1/2/2017.
 */

public class ChildModel extends BaseModel{
    private String tableName = "SWINECHILD";
    private static String[] listField = { "IDCard", "dateOfBirthh", "dateExport",  "totalSwineChild", "totalDead", "History"};
    private List<String []> params = new LinkedList<>();
    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(10) NOT NULL PRIMARY KEY";
        params.add(p);

        String[] p1 = new String[2];
        p1[0] = listField[1];
        p1[1] = "TEXT(10) NOT NULL";
        params.add(p1);

        String[] p2 = new String[2];
        p2[0] = listField[2];
        p2[1] = "TEXT(10)";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[3];
        p3[1] = "INTEGER";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[4];
        p4[1] = "INTEGER";
        params.add(p4);

        String[] p5 = new String[2];
        p5[0] = listField[5];
        p5[1] = "TEXT(1024)";
        params.add(p5);
    }
    public ChildModel(Context context) {
        super(context);
        if (!this.isTableExist(tableName)){
            makeparams();
            this.createTable(tableName,params);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private Map<String, String> makeMap(ChildObject childObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0], childObject.getCardID());
        map.put(listField[1], DateHanding.getDateString(childObject.getDateOfBirthh()));
        map.put(listField[2], DateHanding.getDateString(childObject.getDateExport()));
        map.put(listField[3], childObject.getTotalSwineChild() + "");
        map.put(listField[4], childObject.getTotalDead() + "");
        map.put(listField[5], childObject.getHistoryStr());
        return map;
    }

    public void add(List<ChildObject> childObjects){
        for (ChildObject var : childObjects) add(var);
    }
    public void add(ChildObject childObject){
        this.insert(tableName, makeMap(childObject));
    }

    public void remove(List<ChildObject> childObjects){
        for (ChildObject var : childObjects) remove(var);
    }
    public void remove(ChildObject childObject){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0], childObject.getCardID());
        this.deleteRecord(tableName,map);
    }
    public void remove(String[] id){
        for (String str : id) remove(str);
    }
    public void remove(String id){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0],id);
        this.deleteRecord(tableName,map);
    }

    public void update(List<ChildObject> childObjects){
        for (ChildObject var : childObjects) update(var);
    }
    public void update(ChildObject childObject){
        remove(childObject);
        add(childObject);
    }

    //num is index of listField
    public List<ChildObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<ChildObject> p = new LinkedList<ChildObject>();
        for (String[] var: buff) {
            p.add(new ChildObject(var[0],DateHanding.getDate(var[1]),DateHanding.getDate(var[2]), IntergerHanding.getInterger(var[3]),IntergerHanding.getInterger(var[4]),var[5]));
        }
        return p;
    }
    public List<ChildObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[] {needSearch},"","","");
        List<ChildObject> p = new LinkedList<ChildObject>();
        for (String[] var: buff) {
            p.add(new ChildObject(var[0],DateHanding.getDate(var[1]),DateHanding.getDate(var[2]), IntergerHanding.getInterger(var[3]),IntergerHanding.getInterger(var[4]),var[5]));
        }
        return p;
    }
    public List<ChildObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<ChildObject> p = new LinkedList<ChildObject>();
        for (String[] var: buff) {
            p.add(new ChildObject(var[0],DateHanding.getDate(var[1]),DateHanding.getDate(var[2]), IntergerHanding.getInterger(var[3]),IntergerHanding.getInterger(var[4]),var[5]));
        }
        return p;
    }
    public List<ChildObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<ChildObject> p = new LinkedList<ChildObject>();
        for (String[] var: buff) {
            p.add(new ChildObject(var[0],DateHanding.getDate(var[1]),DateHanding.getDate(var[2]), IntergerHanding.getInterger(var[3]),IntergerHanding.getInterger(var[4]),var[5]));
        }
        return p;
    }

    public List<ChildObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<ChildObject> p = new LinkedList<ChildObject>();
        for (String[] var: buff) {
            p.add(new ChildObject(var[0],DateHanding.getDate(var[1]),DateHanding.getDate(var[2]), IntergerHanding.getInterger(var[3]),IntergerHanding.getInterger(var[4]),var[5]));
        }
        return p;
    }
}
