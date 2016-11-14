package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import objects.VaccineObject;

/**
 * Created by hongnhan on 11/12/2016.
 * list field
 *      id
 *      name
 *      indication
 *      dose
 *      inserted_date
 *      updated_date
 *      inserted_by
 *      updated_by


 */

public class VaccineModel extends BaseModel{
    private String tableName = "VACCINE";
    private List<String []> params;
    private static String[] listField = {"ID","name","indication","dose", "insertedBy","updatedBy","insertedDate","updatedDate"};
    //                                      0   1       2           3           4           5           6               7

    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = listField[1];
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = listField[2];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = listField[3];
        p[1] = "TEXT(50)";
        params.add(p);
        p[0] = listField[4];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = listField[5];
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = listField[6];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = listField[7];
        p[1] = "TEXT(10)";
        params.add(p);
    }
    public VaccineModel(Context context) {
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

    private Map<String, String> makeMap(VaccineObject vaccineObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0],vaccineObject.getID());
        map.put(listField[1],vaccineObject.getName());
        map.put(listField[2],vaccineObject.getIndication());
        map.put(listField[3],vaccineObject.getDose());
        map.put(listField[4],vaccineObject.getInsertedBy());
        map.put(listField[5],vaccineObject.getUpdatedBy());
        map.put(listField[6],DateHanding.getDateString(vaccineObject.getInsertedDate()));
        map.put(listField[7],DateHanding.getDateString(vaccineObject.getUpdatedDate()));
        return map;
    }
    public void add(List<VaccineObject> vaccineObject){
        for (VaccineObject var : vaccineObject) {
            this.insert(tableName, makeMap(var));
        }
    }

    public void remove(List<VaccineObject> vaccineObject){
        Map<String, String> map = new HashMap<String,String>();
        for (VaccineObject var : vaccineObject){
            map.put(listField[0],var.getID());
            this.deleteRecord(tableName,map);
            map.clear();
        }

    }
    public void remove(String[] id){
        Map<String, String> map = new HashMap<String,String>();
        for (String var : id){
            map.put(listField[0],var);
            this.deleteRecord(tableName,map);
            map.clear();
        }

    }
    public void update(List<VaccineObject> vaccineObject){
        Map<String,String> where = new HashMap<String, String>();
        for (VaccineObject var : vaccineObject){
            where.put(listField[0],var.getID());
            this.updateRecord(tableName,makeMap(var),where);
            where.clear();
        }
    }
}
