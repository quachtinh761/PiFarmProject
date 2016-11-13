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

    public String getUserByUserName(String username){
        String conditions = "username = ?";

        return this.searchDataByConditions(tableName, new String[]{"*"}, conditions, null, null, null, null);
    }

    public String isTableExist(){
        return this.isTableExist(this.tableName);
    }

    public boolean createTable(){
        return true;
    }

}
