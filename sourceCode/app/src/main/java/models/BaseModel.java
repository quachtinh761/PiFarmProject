package models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nguyen Van Tinh on 08/11/2016.
 */

public class BaseModel extends SQLiteOpenHelper{

    SQLiteDatabase db = this.getWritableDatabase();
    SQLiteStatement st;
    Cursor rs;

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "pifarm";

    public BaseModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * Map <String, String> params = new HashMap<String,String>();
     * params.put("fieldName1","fieldValue1");
     * params.put("fieldName2","fieldValue2");
     * @param tableName : name of table
     * @param params : insert values
     * @return boolean
     **/
    protected long insert(String tableName, Map<String, String> params){
        ContentValues values = new ContentValues();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            values.put(entry.getKey(), entry.getValue());
        }
        return db.insert(tableName, null,
                values);
    }

    /**
     * @param tableName : name of table
     * @param params
     * List < String[] > params = new ArrayList();
     * params.put("fieldName1","filedType1(primary key if needed)");
     * params.put("fieldName2","filedType2 (not null)");
     * @return boolean
     **/
    protected boolean createTable(String tableName, List< String[] > params){
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
                CREATE_TABLE += ")";
            }else{
                return false;
            }
            db.execSQL(CREATE_TABLE);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /**
     * return true if tableName existed in database
     * otherwise return false
     **/
    protected boolean isTableExist(String tableName) {
        try {
            rs = db.query(tableName, new String[]{"*"}, "1=?", new String[]{"1"}, null, null, null);
            return true;
        }catch (SQLException e){
            return false;
        }
        /*OR
        **String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 = 1";
        **db.rawQuery(sql, null);
        **/
    }

    /**
     * Map <String, String> where = new HashMap<String,String>();
     * where.put("fieldName1","fieldValue1"); //fieldName1 = fieldValue1;
     * where.put("fieldName2","fieldValue2"); //fieldName2 = fieldValue2;
     * AND operator
     * Example sql: DELETE FROM user WHERE username = 'read-only' AND right='4';
     * @param tableName : String
     * @param where : Map<String, String>
     * @return boolean
     **/
    protected boolean deleteRecord(String tableName, Map<String, String> where) {
        if (where.isEmpty()) {
            return false;
        }
        String whereClause = "";
        String[] whereArg = new String[where.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : where.entrySet()) {
            whereClause += entry.getKey() + "=? AND ";
            whereArg[i++] = entry.getValue();
        }
        if (whereClause.endsWith("AND ")) {
            whereClause = whereClause.substring(0, whereClause.length() - 4);
        }
        try {
            return db.delete(tableName, whereClause, whereArg) == 1;
        }catch (SQLException e){
            return false;
        }
    }

    /**
     * Map <String, String> params = new HashMap<String,String>();
     * params.put("fieldName1","fieldValueUpdate1");
     * params.put("fieldName2","fieldValueUpdate2");
     * @param tableName : String
     * @param params : Map<String, String>
     * @param where : Map<String, String>
     * UPDATE user SET right='1', phone_number = '0123456789' WHERE username= 'admin'
     * @return boolean
     **/
    protected boolean updateRecord(String tableName, Map<String, String> params, Map<String, String> where){
        if (params.isEmpty() || where.size() != 2){
            return false;
        }
        ContentValues values = new ContentValues();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            values.put(entry.getKey(), entry.getValue());
        }

        String whereClause = "";
        String[] whereArg = new String[where.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : where.entrySet()) {
            whereClause += entry.getKey() + "=? AND ";
            whereArg[i++] = entry.getValue();
        }
        if (whereClause.endsWith("AND ")){
            whereClause = whereClause.substring(0, whereClause.length() - 4);
        }

        try{
            return db.update(tableName, values, whereClause, whereArg) == 1;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    /**
     * String tableName = "user";
     * String[] tableColumns = new String[] {"username", "password", ....};
     * String whereClause = "phone = ? OR right = ?";
     * String[] whereArgs = new String[] {"016767....", "2"};
     * String groupBy = null;
     * String orderBy = "username";
     **/
    protected List<String[]> searchDataByConditions(String tableName,
                                                 String[] values,
                                                 String whereClause,
                                                 String[] whereArgs,
                                                 String groupBy,
                                                 String having,
                                                 String orderBy){

        if (tableName.equals("") || values.length == 0) return null;

        if (groupBy != null && groupBy.equals("")){
            groupBy = null;
        }
        if (having != null && having.equals("")){
            having = null;
        }
        if (orderBy != null && orderBy.equals("")){
            orderBy = null;
        }
        try {
            rs = db.query(tableName, values, whereClause, whereArgs, groupBy, having, orderBy);
            List<String[]> data = new ArrayList<>();
            if (rs.moveToFirst()) {
                int col = rs.getColumnCount();
                do {
                    String[] row = new String[col];
                    for (int i = 0; i < col; i++){
                        row[i] = rs.getString(i);
                    }
                    data.add(row);
                } while (rs.moveToNext());
            }

            rs.close();
            return data;
        } catch (SQLException e) {
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{e.getMessage()});
            return data;
        }
    }

    protected Cursor customizeSQL(String sql){
        return db.rawQuery(sql, null, null);
    }
}
