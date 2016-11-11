package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import function.StringHanding;
import objects.ParentSwineObject;

/**
 * Created by vanthi on 11/10/2016.
 * list field
 *      id
 *      inport_date
 *      first_vaccine_date
 *      coordination_date
 *      num_of_goat
 *      list_goat
 *      IDProcess
 *      coordinatorID
 *      realDateOfBirth
 *      earNumber


 */

public class SwineModel {
    private String tableName = "SWINE";
    private BaseModel bsmod = new BaseModel();
    private List<String []> params;
    private static String[] listFieldArr = {"id","inport_date","first_vaccine_date","coordination_date",
            "num_of_goat","list_goat","IDProcess","coordinatorID","realDateOfBirth","earNumber"};
    private static List<String> listFieldLs;

    private void makeparams(){
        String[] p = new String[2];
        p[0] = "id";
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = "inport_date";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = "first_vaccine_date";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "coordination_date";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "num_of_goat";
        p[1] = "INTEGER";
        params.add(p);
        p[0] = "list_goat";
        p[1] = "TEXT(300)";
        params.add(p);
        p[0] = "IDProcess";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = "coordinatorID";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = "realDateOfBirth";
        p[1] = "TEXT(10)";
        params.add(p);
        p[0] = "earNumber";
        p[1] = "TEXT(10)";
        params.add(p);

    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public SwineModel() {
        for (String var: listFieldArr) listFieldLs.add(var);
        if (!bsmod.isTableExist(tableName)){
            makeparams();
            bsmod.createTable(tableName,params);
        }
    }
    private Map<String, String> makeMapToAdd(ParentSwineObject parentSwineObject){
        Map<String, String> map = new HashMap<String, String>();
        map.put("id",parentSwineObject.getID());
        map.put("inport_date", DateHanding.getDateString(parentSwineObject.getDateImport()));
        map.put("first_vaccine_date", DateHanding.getDateString(parentSwineObject.getFirstVaccineDate()));
        map.put("coordination_date",DateHanding.getDateString(parentSwineObject.getMatingDate()));
        map.put("num_of_goat", String.valueOf(parentSwineObject.getTotalChilds()));

        String list_goat = "";
        String dataInList = StringHanding.add(list_goat,StringHanding.parseTwoNumber(parentSwineObject.getTotalChilds())+
                            StringHanding.parseTwoNumber(parentSwineObject.getNumberChildsDie())+parentSwineObject.getRealDateOfBirth());
        list_goat = StringHanding.add(list_goat,dataInList);
        map.put("list_goat",list_goat);

        map.put("IDProcess" , parentSwineObject.getProcessID());
        map.put("coordinatorID", parentSwineObject.getCoordinatorID());
        map.put("realDateOfBirth", DateHanding.getDateString(parentSwineObject.getRealDateOfBirth()));
        map.put("earNumber", parentSwineObject.getEarNumber());
        return map;
    }

    public void add(ParentSwineObject paSwineOb){
        bsmod.insertTable(tableName,makeMapToAdd(paSwineOb));
    }

    public void remove(ParentSwineObject parentSwineObject){
        Map<String, String> map = new HashMap<String,String>();
        map.put("id",parentSwineObject.getID());
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

    public ParentSwineObject read(String id){
        ResultSet rs = bsmod.search(tableName,"id",id);
        if (rs == null) return null;
        else {
            //listFieldArr = {"id","inport_date","first_vaccine_date","coordination_date",
             //       "num_of_goat","list_goat","IDProcess","coordinatorID","realDateOfBirth","earNumber"};
            /*private String ID;
     private Date dateImport;               1
    private String earNumber;
    private Date matingDate;
    private String coordinatorID;               3
    private Date expectedDateOfBirth;
    private Date realDateOfBirth;
    private int timesOfBirth;
    private int totalChilds;                    4
    private String processID;                   6
    private Date firstVaccineDate;              2
    private String lsGOAT;                      5
    private int numberChildsDie;*/
            try {
                String[] ls = new String[listFieldArr.length - 1];
                for (int i = 0; i < listFieldArr.length -1; i++){
                    ls[i] = rs.getString(listFieldArr[i+1]);
                }
                return new ParentSwineObject(id,)
            }
            catch (SQLException e){

            }
        }
    }
}
