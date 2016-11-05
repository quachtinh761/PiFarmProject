package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Created by Nguyen Van Tinh on 23/10/2016.
 */
public class BaseModel {
    String dbPath = "jdbc:sqlite:" + "/test.db";
    //Class.forName("org.sqldroid.SQLDroidDriver");
    //getData
    protected Connection conn;
    protected Statement st = null;
    protected ResultSet rs = null;

    public void getConnect(){
        try{
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
            this.st = this.conn.createStatement();
        }
        catch(ClassNotFoundException e){
        }
        catch(SQLException e){
        }
    }

    public boolean closeConnect(){
        try {
            if (this.conn != null){
                this.conn.close();
            }
            if (this.st != null){
                this.st.close();
            }
            if (this.rs != null){
                this.rs.close();
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * @param tableName
     * @param params
     * List < String[] > params = ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     * @return boolean
     **/
    public boolean createTable(String tableName, List< String[] > params){
        int name = 0, type = 1;
        try {
            String CREATE_TABLE = "";
            if ( this.isTableExist(tableName) ){
                return true;
            }
            CREATE_TABLE += "CREATE TABLE " + tableName.toUpperCase() + "(";
            for (int i = 0; i < params.size(); i++){
                CREATE_TABLE += params.get(i)[name] + " " + params.get(i)[type] + ",";
            }
            if (CREATE_TABLE.endsWith(",")){
                CREATE_TABLE = CREATE_TABLE.substring(0, CREATE_TABLE.length() - 1);
                CREATE_TABLE += ") ";
            }else{
                return false;
            }
            return st.execute(CREATE_TABLE);
        }catch (Exception ex){
            return false;
        }
    }

    /**
     * return true if tableName existed int database
     **/
    public boolean isTableExist(String tableName) {
        try{
            String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 = 1";
            rs = st.executeQuery(sql);
        }catch(SQLException e){
            return false;
        }
        return true;
    }

    /**
     * Map <String, String> params = new HashMap<String,String>();
     * params.put("fieldName1","fieldValue1");
     * params.put("fieldName2","fieldValue2");
     * @param tableName
     * @param params
     * @return boolean
     **/
    public boolean insertTable(String tableName, Map<String, String> params) {
        //Open connection to write data
        String sql = "INSERT INTO " + tableName.toUpperCase() + "(";
        String key = "", value = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            key += entry.getKey() + ",";
            value += "'" + entry.getValue() + "',";
        }
        if (key.endsWith(",")){
            key = key.substring(0, key.length() - 1);
        }
        if (value.endsWith(",")){
            value = value.substring(0, value.length() - 1);
        }
        if (params.isEmpty()){
            return false;
        }
        sql += key + ") VALUES (" + value + ")";

        try {
            return st.execute(sql);
        }catch (SQLException e){
            return false;
        }
    }
}
