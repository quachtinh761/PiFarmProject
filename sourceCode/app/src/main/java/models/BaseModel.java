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
     * @param tableName
     * @param params
     * @return boolean
     **/
    public long insert(String tableName, Map<String, String> params){
        ContentValues values = new ContentValues();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            values.put(entry.getKey(), entry.getValue());
        }
        return db.insert("USER", null,
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
    public boolean createTable(String tableName, List< String[] > params){
        int name = 0, type = 1;
        try {
            String CREATE_TABLE = "";
            if ( this.isTableExist(tableName).equals("TRUE") ){
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
            db.compileStatement(CREATE_TABLE);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    /**
     * return true if tableName existed in database
     * otherwise return false
     **/
    protected boolean isTableExist1(String tableName) {
        try {
            rs = db.query(tableName, new String[]{"*"}, "1=?", new String[]{"1"}, null, null, null);
            return rs.getCount() > 0;
        }catch (SQLException e){
            return false;
        }
        /*OR
        **String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 = 1";
        **db.rawQuery(sql, null);
        **/
    }

    /**
     * return true if tableName existed in database
     * otherwise return false
     **/
    protected String isTableExist(String tableName) {
        try {
            rs = db.query(tableName, new String[]{"*"}, "1=?", new String[]{"1"}, null, null, null);
            return rs.toString();
        }catch (SQLException e){
            return e.getMessage();
        }
        /*OR
        **String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 = 1";
        **db.rawQuery(sql, null);
        **/
    }

    /**
     * String tableName = "user";
     * String[] tableColumns = new String[] {"username", "password", ....};
     * String whereClause = "phone = ? OR right = ?";
     * String[] whereArgs = new String[] {"016767....", "2"};
     * String groupBy = null;
     * String orderBy = "username";
     **/
    protected List<String[]> searchDataByConditions1(String tableName,
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
            return null;
        }
    }

    protected String searchDataByConditions(String tableName,
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
            return "Success";
            //return data;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

}
