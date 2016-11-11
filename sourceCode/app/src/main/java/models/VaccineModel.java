package models;

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

public class VaccineModel {
    private String tableName = "VACCINE";
    private BaseModel bsmod = new BaseModel();
    private List<String []> params;
    private static String[] listFieldArr = {"id","name","indication","dose",
            "inserted_date","updated_date","inserted_by","updated_by"};
    private static List<String> listFieldLs;

    private void makeparams(){
        String[] p = new String[2];
        p[0] = "id";
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = "name";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "indication";
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = "dose";
        p[1] = "TEXT(50)";
        params.add(p);
        p[0] = "inserted_date";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "updated_date";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "inserted_by";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = "updated_by";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public VaccineModel() {
        for (String var: listFieldArr) listFieldLs.add(var);
        if (!bsmod.isTableExist(tableName)){
            makeparams();
            bsmod.createTable(tableName,params);
        }
    }

    private Map<String, String> makeMapToAdd(VaccineObject vaccineObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put("id",vaccineObject.getID());
        map.put("name",vaccineObject.getName());
        map.put("indication",vaccineObject.getIndication());
        map.put("dose",vaccineObject.getDose());
        map.put("inserted_date",DateHanding.getDateString(vaccineObject.getInsertedDate()));
        map.put("updated_date",DateHanding.getDateString(vaccineObject.getUpdatedDate()));
        map.put("inserted_by",vaccineObject.getInsertedBy());
        map.put("updated_by",vaccineObject.getUpdatedBy());

        return map;
    }
    public void add(VaccineObject vaccineObject){
        bsmod.insertTable(tableName,makeMapToAdd(vaccineObject));
    }

    public void remove(VaccineObject vaccineObject){
        Map<String, String> map = new HashMap<String,String>();
        map.put("id",vaccineObject.getID());
        bsmod.deleteRecord(tableName,map);
    }
    public void remove(String id){
        Map<String, String> map = new HashMap<String,String>();
        map.put("id",id);
        bsmod.deleteRecord(tableName,map);
    }
    /*
    * listDataUpdate include Interger is order of listField and String is Value
    * exam you want update coordination_date
    * int list have <3, 11-11-1111>
    *     3 is 3th in listField that is coordination_date
     */
    public void update(String id, Map<Integer, String> listDataUpdate){
        Map<String,String> map = new HashMap<String,String>();
        for (Map.Entry<Integer, String> var : listDataUpdate.entrySet()){
            map.put(listFieldArr[var.getKey()],var.getValue());
        }
        String[] lsID = {id};
        bsmod.updateRecord(tableName,map,lsID);
    }

    /*
    *You can update more Swine by list ID if it same value to update
     */
    public void update(String[] lsID, Map<Integer, String> listDataUpdate){
        Map<String,String> map = new HashMap<String,String>();
        for (Map.Entry<Integer, String> var : listDataUpdate.entrySet()){
            map.put(listFieldArr[var.getKey()],var.getValue());
        }
        bsmod.updateRecord(tableName,map,lsID);
    }
}
