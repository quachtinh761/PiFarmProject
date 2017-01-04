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
    private static String[] listField = {"ID","name","indication","dose", "insertedBy","updatedBy","insertedDate","updatedDate", "HaveUse"};
    //                                      0   1       2           3           4           5           6               7

    private void makeparams(){
        String[] p1 = new String[2];
        p1[0] = listField[0];
        p1[1] = "TEXT(50) NOT NULL ";
        params.add(p1);

        String[] p2 = new String[2];
        p2[0] = listField[1];
        p2[1] = "TEXT(10)";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[2];
        p3[1] = "TEXT(50) NOT NULL";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[3];
        p4[1] = "TEXT(50)";
        params.add(p4);

        String[] p5 = new String[2];
        p5[0] = listField[4];
        p5[1] = "TEXT(10) NOT NULL";
        params.add(p5);

        String[] p6 = new String[2];
        p6[0] = listField[5];
        p6[1] = "TEXT(10)";
        params.add(p6);

        String[] p7 = new String[2];
        p7[0] = listField[6];
        p7[1] = "TEXT(10) NOT NULL";
        params.add(p7);

        String[] p8 = new String[2];
        p8[0] = listField[7];
        p8[1] = "TEXT(10)";
        params.add(p8);

        String[] p9 = new String[2];
        p9[0] = listField[8];
        p9[2] = "INTEGER";
        params.add(p9);
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
        map.put(listField[8], vaccineObject.isHaveUse() ? "1" : "0");
        return map;
    }
    public void add(List<VaccineObject> vaccineObject){
        for (VaccineObject var : vaccineObject) {
            add(var);
        }
    }
    public void add(VaccineObject vaccineObject){
        this.insert(tableName, makeMap(vaccineObject));
    }

    public void remove(VaccineObject vaccineObject){
        Map<String, String> map = new HashMap<>();
        map.put(listField[0], vaccineObject.getID());
        this.deleteRecord(tableName, map);
        map.clear();
    }
    public void remove(List<VaccineObject> vaccineObject){
        for (VaccineObject var : vaccineObject){
            remove(var);
        }
    }
    public void remove(String id){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0],id);
        this.deleteRecord(tableName,map);
        map.clear();
    }
    public void remove(String[] id){
        for (String var : id){
            remove(var);
        }
    }
    public void update(VaccineObject vaccineObject){
        remove(vaccineObject);
        add(vaccineObject);
    }
    public void update(List<VaccineObject> vaccineObject){
        for (VaccineObject vacine : vaccineObject){
            update(vacine);
        }
    }

    //num is index of listField = {"ID","name","indication","dose", "insertedBy","updatedBy","insertedDate","updatedDate"};
    public List<VaccineObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<VaccineObject> p = new LinkedList<VaccineObject>();
        for (String[] var: buff) {
            p.add(new VaccineObject(var[0], var[1],var[2],var[3],var[4], var[5],DateHanding.getDate(var[6]),DateHanding.getDate(var[7]), var[8].equals("1") ? true : false));
        }
        return p;
    }
    public List<VaccineObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[]{needSearch},"","","");
        List<VaccineObject> p = new LinkedList<VaccineObject>();
        for (String[] var: buff) {
            p.add(new VaccineObject(var[0], var[1],var[2],var[3],var[4], var[5],DateHanding.getDate(var[6]),DateHanding.getDate(var[7]), var[8].equals("1") ? true : false));
        }
        return p;
    }
    public List<VaccineObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<VaccineObject> p = new LinkedList<VaccineObject>();
        for (String[] var: buff) {
            p.add(new VaccineObject(var[0], var[1],var[2],var[3],var[4], var[5],DateHanding.getDate(var[6]),DateHanding.getDate(var[7]), var[8].equals("1") ? true : false));
        }
        return p;
    }
    public List<VaccineObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<VaccineObject> p = new LinkedList<VaccineObject>();
        for (String[] var: buff) {
            p.add(new VaccineObject(var[0], var[1],var[2],var[3],var[4], var[5],DateHanding.getDate(var[6]),DateHanding.getDate(var[7]), var[8].equals("1") ? true : false));
        }
        return p;
    }

    public List<VaccineObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<VaccineObject> p = new LinkedList<VaccineObject>();
        for (String[] var: buff) {
            p.add(new VaccineObject(var[0], var[1],var[2],var[3],var[4], var[5],DateHanding.getDate(var[6]),DateHanding.getDate(var[7]), var[8].equals("1") ? true : false));
        }
        return p;
    }

}
