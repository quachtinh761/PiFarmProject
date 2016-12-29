package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import function.IntergerHanding;
import function.StringHanding;
import objects.ProcessObject;

/**
 * Created by Van Thi on 12/29/2016.
 */

public class ProcessModel extends BaseModel {
    private String tableName = "PROCESS";
    private static String[] listField = {"Type","nDay","DateOfBirth","ListVaccineID", "HaveUse"};
    //                                     0 ,  1           ,2              3              4
    private List<String []> params = new LinkedList<>();
    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "INTEGER NOT NULL";
        params.add(p);

        String[] p1 = new String[2];
        p1[0] = listField[1];
        p1[1] = "INTERGER";
        params.add(p1);

        String[] p2 = new String[2];
        p2[0] = listField[2];
        p2[1] = "TEXT(10)";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[3];
        p3[1] = "TEXT(256)";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[4];
        p4[1] = "INTEGER";
        params.add(p4);
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public ProcessModel(Context context) {
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

    private Map<String, String> makeMap(ProcessObject processObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0], processObject.getType() + "");
        map.put(listField[1], processObject.getnDay() + "");
        map.put(listField[2], DateHanding.getDateString(processObject.getDateOfBirth()));
        map.put(listField[3], StringHanding.getStr(processObject.getLsVaccineID()));
        map.put(listField[4], processObject.isHaveUse() ? "1" : "0");
        return map;
    }
    public void add(List<ProcessObject> processObjects){
        for (ProcessObject var : processObjects){
            this.insert(tableName,makeMap(var));
        }
    }
    public void add(ProcessObject processObject){
        this.insert(tableName,makeMap(processObject));
    }

    //num is index of listField
    public List<ProcessObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<ProcessObject> p = new LinkedList<ProcessObject>();
        for (String[] var: buff) {
            p.add(new ProcessObject(IntergerHanding.getInterger(var[0]), IntergerHanding.getInterger(var[1]), DateHanding.getDate(var[2]), var[3], var[4].equals("1") ? true : false));
        }
        return p;
    }
    public List<ProcessObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[]{needSearch},"","","");
        List<ProcessObject> p = new LinkedList<ProcessObject>();
        for (String[] var: buff) {
            p.add(new ProcessObject(IntergerHanding.getInterger(var[0]), IntergerHanding.getInterger(var[1]), DateHanding.getDate(var[2]), var[3], var[4].equals("1") ? true : false));
        }
        return p;
    }
    public List<ProcessObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<ProcessObject> p = new LinkedList<ProcessObject>();
        for (String[] var: buff) {
            p.add(new ProcessObject(IntergerHanding.getInterger(var[0]), IntergerHanding.getInterger(var[1]), DateHanding.getDate(var[2]), var[3], var[4].equals("1") ? true : false));
        }
        return p;
    }
    public List<ProcessObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<ProcessObject> p = new LinkedList<ProcessObject>();
        for (String[] var: buff) {
            p.add(new ProcessObject(IntergerHanding.getInterger(var[0]), IntergerHanding.getInterger(var[1]), DateHanding.getDate(var[2]), var[3], var[4].equals("1") ? true : false));
        }
        return p;
    }

    public List<ProcessObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<ProcessObject> p = new LinkedList<ProcessObject>();
        for (String[] var: buff) {
            p.add(new ProcessObject(IntergerHanding.getInterger(var[0]), IntergerHanding.getInterger(var[1]), DateHanding.getDate(var[2]), var[3], var[4].equals("1") ? true : false));
        }
        return p;
    }
}
