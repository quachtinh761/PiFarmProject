package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import function.IntergerHanding;
import function.StringHanding;
import objects.ParentProcessObject;

/**
 * Created by nguyenvanthi on 13/11/2016.
 */

public class ParentProcessModel extends BaseModel{
    private String tableName = "PARENTPROCESS";
    private static String[] listField = {"ID","nDayAfterImport","listVaccineImport","nDayAfterCoordination", "listVaccineCoordination"};
    //                                     0 ,  1                        ,2              3                            4
    private List<String []> params = new LinkedList<>();
    private void makeparams(){
        String[] p = new String[2];
        p[0] = listField[0];
        p[1] = "TEXT(10) NOT NULL PRIMARY KEY";
        params.add(p);

        String[] p1 = new String[2];
        p1[0] = listField[1];
        p1[1] = "INTEGER";
        params.add(p1);

        String[] p2 = new String[2];
        p2[0] = listField[2];
        p2[1] = "TEXT(1500)";
        params.add(p2);

        String[] p3 = new String[2];
        p3[0] = listField[3];
        p3[1] = "INTEGER";
        params.add(p3);

        String[] p4 = new String[2];
        p4[0] = listField[4];
        p4[1] = "TEXT(1500)";
        params.add(p4);
    }
    public ParentProcessModel(Context context) {
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

    private Map<String, String> makeMap(ParentProcessObject parentProcessObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put(listField[0],parentProcessObject.getID());
        map.put(listField[1], String.valueOf(parentProcessObject.getnDayAfterImport()));
        List<String> buff = new ArrayList<String>();
        for (Map.Entry<String, Integer> var : parentProcessObject.getListVaccineImport().entrySet()){
            buff.add(var.getKey());
            buff.add(String.valueOf(var.getValue()));
        }
        String p = StringHanding.getStr(buff);
        map.put(listField[2], p);

        map.put(listField[3],String.valueOf(parentProcessObject.getnDayAfterCoordination()));

        buff.clear();
        for (Map.Entry<String, Integer> var : parentProcessObject.getListVaccineCoordination().entrySet()){
            buff.add(var.getKey());
            buff.add(String.valueOf(var.getValue()));
        }
        p = StringHanding.getStr(buff);
        map.put(listField[4], p);

        return map;
    }
    public void add(List<ParentProcessObject> parentProcessOb){
        for (ParentProcessObject var : parentProcessOb)add(var);
    }
    public void add(ParentProcessObject parentProcessObject){
        this.insert(tableName, makeMap(parentProcessObject));
    }

    public void remove(List<ParentProcessObject> parentProcessOb){
        for (ParentProcessObject var : parentProcessOb) remove(var);
    }
    public void remove(ParentProcessObject parentProcessObject){
        Map<String, String> map = new HashMap<String,String>();
        map.put(listField[0], parentProcessObject.getID());
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

    public void update(List<ParentProcessObject> parentProcessObjects){
        for (ParentProcessObject var : parentProcessObjects)update(var);
    }
    public void update(ParentProcessObject parentProcessObject){
        remove(parentProcessObject.getID());
        insert(tableName, makeMap(parentProcessObject));
    }

    private Map<String,Integer> makeMap(String data){
        String[] temp = StringHanding.getArrayStr(data);
        Map<String,Integer> ret = new HashMap<String, Integer>();
        for (int i = 0; i < temp.length; i++){
            ret.put(temp[i], IntergerHanding.getInterger(temp[i+1]));
            i++;
        }
        return ret;
    }
    //num is index of listField
    public List<ParentProcessObject> search(String[] needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",needSearch,"","","");
        List<ParentProcessObject> p = new LinkedList<ParentProcessObject>();
        for (String[] var: buff) {
            p.add(new ParentProcessObject(var[0], IntergerHanding.getInterger(var[1]), makeMap(var[2]),IntergerHanding.getInterger(var[3]),makeMap(var[4])));
        }
        return p;
    }
    public List<ParentProcessObject> search(String needSearch,int num){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[num] + "= ?",new String[]{needSearch},"","","");
        List<ParentProcessObject> p = new LinkedList<ParentProcessObject>();
        for (String[] var: buff) {
            p.add(new ParentProcessObject(var[0], IntergerHanding.getInterger(var[1]), makeMap(var[2]),IntergerHanding.getInterger(var[3]),makeMap(var[4])));
        }
        return p;
    }
    public List<ParentProcessObject> search(String[] needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",needSearch,"","","");
        List<ParentProcessObject> p = new LinkedList<ParentProcessObject>();
        for (String[] var: buff) {
            p.add(new ParentProcessObject(var[0], IntergerHanding.getInterger(var[1]), makeMap(var[2]),IntergerHanding.getInterger(var[3]),makeMap(var[4])));
        }
        return p;
    }
    public List<ParentProcessObject> search(String needSearch){
        List<String []> buff = searchDataByConditions(tableName,listField,listField[0] + "= ?",new String[]{needSearch},"","","");
        List<ParentProcessObject> p = new LinkedList<ParentProcessObject>();
        for (String[] var: buff) {
            p.add(new ParentProcessObject(var[0], IntergerHanding.getInterger(var[1]), makeMap(var[2]),IntergerHanding.getInterger(var[3]),makeMap(var[4])));
        }
        return p;
    }

    public List<ParentProcessObject> searchAll(){
        List<String []> buff = searchDataByConditions(tableName,listField,null,null,"","","");
        List<ParentProcessObject> p = new LinkedList<ParentProcessObject>();
        for (String[] var: buff) {
            p.add(new ParentProcessObject(var[0], IntergerHanding.getInterger(var[1]), makeMap(var[2]),IntergerHanding.getInterger(var[3]),makeMap(var[4])));
        }
        return p;
    }
}
