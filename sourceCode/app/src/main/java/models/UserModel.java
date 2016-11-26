package models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import models.BaseModel;
import objects.userObject;

/**
 * Created by Nguyen Van Tinh on 06/11/2016.
 */

public class UserModel extends BaseModel{
    final String tableName = "USER";
    final String[] colName = new String[]{
            "username",         //0
            "password",         //1
            "first_name",       //2
            "last_name",        //3
            "phone_number",     //4
            "birthday",         //5
            "right",            //6
            "start_work_at",    //7
            "inserted_by",      //8
            "inserted_at",      //9
            "updated_at",       //10
            "updated_by"        //11
    };

    public UserModel(Context context) {
        super(context);
        this.createTableUser();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<String[]> getUserByUserName(String username){
        String whereClause = "username = ?";
        String[] whereArgs = new String[]{username};
        return this.searchDataByConditions(tableName, new String[]{"*"}, whereClause, whereArgs, null, null, null);
    }

    public boolean isTableExist(){
        return this.isTableExist(this.tableName);
    }

    public boolean createTableUser(){
        List < String[] > params = new ArrayList<String[]>();
        params.add(new String[]{colName[0], "TEXT(50) NOT NULL PRIMARY KEY"});
        params.add(new String[]{colName[1], "TEXT(20) NOT NULL"});
        params.add(new String[]{colName[2], "TEXT(50) NOT NULL"});
        params.add(new String[]{colName[3], "TEXT(50) NOT NULL"});
        params.add(new String[]{colName[4], "TEXT(11) NOT NULL"});
        params.add(new String[]{colName[5], "TEXT(10) NOT NULL"});
        params.add(new String[]{colName[6], "TEXT(1) NOT NULL"});
        params.add(new String[]{colName[7], "TEXT(10) NOT NULL"});
        params.add(new String[]{colName[8], "TEXT(10) NOT NULL"});
        params.add(new String[]{colName[9], "TEXT(10) NOT NULL"});
        params.add(new String[]{colName[10],"TEXT(50)"});
        params.add(new String[]{colName[11],"TEXT(50)"});
        return this.createTable(this.tableName, params);
    }

    public boolean addUser(userObject user){
        Map <String, String> params = new HashMap<String,String>();
        params.put(colName[0], user.getId());
        params.put(colName[1], user.getPassword());
        params.put(colName[2], user.getFirst_name());
        params.put(colName[3], user.getLast_name());
        params.put(colName[4], user.getPhone_number());
        params.put(colName[5], user.getBirthday_string());
        params.put(colName[6], user.getRight());
        params.put(colName[7], DateHanding.getDateString(new Date()));
        params.put(colName[8], DateHanding.getDateString(new Date()));
        params.put(colName[9], user.getId());
        params.put(colName[10], DateHanding.getDateString(new Date()));
        params.put(colName[11], user.getId());
        return this.insert(this.tableName, params) != 0;
    }

    public Cursor run(String sql){
        return this.customizeSQL(sql);
    }

}
