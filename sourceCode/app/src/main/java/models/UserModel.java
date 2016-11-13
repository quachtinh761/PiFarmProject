package models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public boolean createTable(){
        return true;
    }

}
