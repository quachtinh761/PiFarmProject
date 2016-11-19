package models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.BaseModel;

/**
 * Created by Nguyen Van Tinh on 06/11/2016.
 */

public class UserModel extends BaseModel{
    final String tableName = "USER";

    public UserModel(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.createTableUser();
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
        params.add(new String[]{"username","TEXT(50) NOT NULL PRIMARY KEY"});
        params.add(new String[]{"password","TEXT(20) NOT NULL"});
        params.add(new String[]{"first_name","TEXT(50) NOT NULL"});
        params.add(new String[]{"last_name","TEXT(50) NOT NULL"});
        params.add(new String[]{"phone_number","TEXT(11) NOT NULL"});
        params.add(new String[]{"birthday","TEXT(10) NOT NULL"});
        params.add(new String[]{"right","TEXT(1) NOT NULL"});
        params.add(new String[]{"start_work_at","TEXT(10) NOT NULL"});
        params.add(new String[]{"inserted_at","TEXT(10) NOT NULL"});
        params.add(new String[]{"updated_at","TEXT(10) NOT NULL"});
        params.add(new String[]{"inserted_by","TEXT(50)"});
        params.add(new String[]{"updated_by","TEXT(50)"});
        return this.createTable(this.tableName, params);
    }

    public Cursor run(String sql){
        return this.customizeSQL(sql);
    }

}
