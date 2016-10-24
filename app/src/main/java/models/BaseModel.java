package models;

import java.sql.DriverManager;
/**
 * Created by Nguyen Van Tinh on 23/10/2016.
 */
public class BaseModel {
    String dbPath = "jdbc:sqlite:" + "/test.db";
    //Class.forName("org.sqldroid.SQLDroidDriver");
    //getData

    public static void getConnect(){
    }
}
