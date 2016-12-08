package models;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import function.DateHanding;
import function.IntergerHanding;
import function.StringHanding;
import objects.ChildProcessObject;
import objects.ParentProcessObject;
import objects.ParentSwineObject;

/**
 * Created by nguyenvanthi on 13/11/2016.
 */

public class ParentSwineModel extends BaseModel{
    private String tableName = "PARENTSWINE";
    private static String[] listField = {"ID","dateImport","earNumber","dateCoordination", "coordinatorID","IDprocess","process","lsChildID","note"};
    //                                     0 ,  1           ,2              3                   4               5           6           7       8
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
        p2[1] = "TEXT(10) NOT NULL";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[3];
        p3[1] = "TEXT(10)";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[4];
        p4[1] = "TEXT(10)";
        params.add(p4);

        String[] p5 = new String[2];
        p5[0] = listField[5];
        p5[1] = "TEXT(10) NOT NULL";
        params.add(p5);

        String[] p6 = new String[2];
        p6[0] = listField[6];
        p6[1] = "TEXT(500)";
        params.add(p6);

        String[] p7 = new String[2];
        p7[0] = listField[7];
        p7[1] = "TEXT(300)";
        params.add(p7);

        String[] p8 = new String[2];
        p8[0] = listField[8];
        p8[1] = "TEXT(512)";
        params.add(p8);
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public ParentSwineModel(Context context) {
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

    private Map<String, String> makeMap(ParentSwineObject parentSwineObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0],parentSwineObject.getID());
        map.put(listField[1], DateHanding.getDateString(parentSwineObject.getDateImport()));
        map.put(listField[2], parentSwineObject.getEarNumber());
        map.put(listField[3],DateHanding.getDateString(parentSwineObject.getDateCoordination()));
        map.put(listField[4], parentSwineObject.getCoordinatorID());
        map.put(listField[5], parentSwineObject.getIDprocess());
        map.put(listField[6], parentSwineObject.getProcess());
        map.put(listField[7], parentSwineObject.getLsChildID());
        map.put(listField[8], parentSwineObject.getNote());
        return map;
    }
    public void add(List<ParentSwineObject> paSwineOb){
        for (ParentSwineObject var : paSwineOb){
            this.insert(tableName,makeMap(var));
        }
    }
    public void add(ParentSwineObject parentSwineObject){
        this.insert(tableName,makeMap(parentSwineObject));
    }

    public void remove(List<ParentSwineObject> parentSwineObject){
        for (ParentSwineObject var : parentSwineObject)remove(var);
    }
    public void remove(ParentSwineObject parentSwineObject){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0], parentSwineObject.getID());
        this.deleteRecord(tableName, map);
    }
    public void remove(String[] id){
        for (String var : id)remove(var);
    }
    public void remove(String id){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0],id);
        this.deleteRecord(tableName,map);
    }

    public void update(List<ParentSwineObject> parentSwineObjects){
        for (ParentSwineObject var : parentSwineObjects) update(var);
    }
    public void update(ParentSwineObject parentSwineObject){
        remove(parentSwineObject);
        add(parentSwineObject);
    }

    //num is index of listField
    public List<ParentSwineObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }
        return p;
    }
    public List<ParentSwineObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[]{needSearch},"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }
        return p;
    }
    public List<ParentSwineObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }
        return p;
    }
    public List<ParentSwineObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }
        return p;
    }

    public List<ParentSwineObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }


        return p;
    }
}
