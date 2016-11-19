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
    private List<String []> params;
    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);

        p[0] = listField[1];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);

        p[0] = listField[2];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);

        p[0] = listField[3];
        p[1] = "TEXT(10)";
        params.add(p);

        p[0] = listField[4];
        p[1] = "TEXT(10)";
        params.add(p);

        p[0] = listField[5];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);

        p[0] = listField[6];
        p[1] = "TEXT(500)";
        params.add(p);


        p[0] = listField[7];
        p[1] = "TEXT(300)";
        params.add(p);

        p[0] = listField[8];
        p[1] = "TEXT(512)";
        params.add(p);
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

    public void remove(List<ParentSwineObject> parentSwineObject){
        Map<String, String> map = new HashMap<String,String>();
        for (ParentSwineObject var : parentSwineObject){
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

    public void update(List<ParentSwineObject> parentSwineObjects){
        Map<String,String> where = new HashMap<String, String>();
        for (ParentSwineObject var : parentSwineObjects){
            where.put(listField[0],var.getID());
            this.updateRecord(tableName,makeMap(var),where);
            where.clear();
        }
    }
    //num is index of listField
    public List<ParentSwineObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num],needSearch,"","","");
        List<ParentSwineObject> p = new LinkedList<ParentSwineObject>();
        for (String[] var: buff) {
            p.add(new ParentSwineObject(var[0], DateHanding.getDate(var[1]) ,var[2],DateHanding.getDate(var[3]),var[4],
                    DateHanding.getDateAfter(DateHanding.getDate(var[3]),115),var[5],var[6],var[7],var[8]));
        }
        return p;
    }
}
