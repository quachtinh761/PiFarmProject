package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.ParentSwineObject;

/**
 * Created by vanthi on 11/10/2016.
 */

public class SwineModel {
    private String tableName = "SWINE";
    BaseModel bsmod = new BaseModel();
    List<String []> params;
    private void makeparams(){
        String[] p = new String[2];
        p[0] = "id";
        p[1] = "TEXT(50) NOT NULL";
        params.add(p);
        p[0] = "inport_date";
        p[1] = "TEXT(10) NOT NULL";
        params.add(p);
        p[0] = "first_vaccine_date";
        p[1] = "TEXT(10) NOT NULL";
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

    }
    /*
    * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     */
    public SwineModel() {
        if (!bsmod.isTableExist(tableName)){
            bsmod.createTable(tableName,params);
        }
    }
    public void add(ParentSwineObject paSwineOb){
        //Map<String, String> map = new HashMap<String,String>();
        //map.put("id")
        //bsmod.insertTable(tableName,)
    }
}
