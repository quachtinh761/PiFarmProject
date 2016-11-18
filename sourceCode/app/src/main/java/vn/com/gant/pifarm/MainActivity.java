package vn.com.gant.pifarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.ParseException;

import controllers.LoginController;
import function.DateHanding;
import objects.ParentProcessObject;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "LoginMessages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);

//        Log.i(TAG,"user name:");

//        SaveSharedPreference.clearUserName(MainActivity.this);
        Intent directIntent = new Intent(this, LoginController.class);

        startActivity(directIntent);
        ///end functions
        /*
        if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0){
            // create Intent
            Intent mainIntent = new Intent(MainActivity.this, LoginController.class);

            MainActivity.this.startActivity(mainIntent);

            finish();
        } else {
            // create Intent
            Intent mainIntent = new Intent(MainActivity.this, Features.class);

            MainActivity.this.startActivity(mainIntent);

            finish();
        }*/


    }
}
