package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.StringHanding;
import objects.ChildProcessObject;
import objects.ParentProcessObject;

/**
 * Created by nguyenvanthi on 13/11/2016.
 */

public class ChildProcessModel extends BaseModel{
    private String tableName = "CHILDPROCESS";
    private static String[] listField = {"ID","nDayAfterBorn","lsVaccine"};
    //                                     0 ,  1                   2
    private List<String []> params;
    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);

        p[0] = listField[1];
        p[1] = "INTEGER";
        params.add(p);

        p[0] = listField[2];
        p[1] = "TEXT(150)";
        params.add(p);
    }

    public ChildProcessModel(Context context) {
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
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */

    private Map<String, String> makeMap(ChildProcessObject childProcessObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0],childProcessObject.getID());
        map.put(listField[1], String.valueOf(childProcessObject.getnDayAfterBorn()));
        List<String> buff = new ArrayList<String>();
        for (Map.Entry<String, Integer> var : childProcessObject.getLsVaccine().entrySet()){
            buff.add(var.getKey());
            buff.add(String.valueOf(var.getValue()));
        }
        String p = StringHanding.getStr(buff);
        map.put(listField[2], p);

        return map;
    }

    public void add(List<ChildProcessObject> childProcessObjects){
        for (ChildProcessObject var : childProcessObjects){
            this.insert(tableName,makeMap(var));
        }
    }

    public void remove(List<ChildProcessObject> childProcessObject){
        Map<String, String> map = new HashMap<String,String>();
        for (ChildProcessObject var : childProcessObject){
            map.put(listField[0],var.getID());
            this.deleteRecord(tableName,map);
            map.clear();
        }

    }
    public void remove(String[] id){
        Map<String, String> map = new HashMap<String,String>();
        for (String str : id){
            map.put(listField[0],str);
            this.deleteRecord(tableName,map);
            map.clear();
        }

    }

    public void update(List<ChildProcessObject> childProcessObject){
        Map<String,String> where = new HashMap<String, String>();
        for (ChildProcessObject var : childProcessObject){
            where.put(listField[0],var.getID());
            this.updateRecord(tableName,makeMap(var),where);
            where.clear();
        }

    }
}
