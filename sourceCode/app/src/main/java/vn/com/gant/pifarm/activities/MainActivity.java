package vn.com.gant.pifarm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.com.gant.pifarm.SaveSharedPreference;
import vn.com.gant.pifarm.TestByVanThiAll;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "LoginMessages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0){
            // create Intent
            Intent mainIntent = new Intent(MainActivity.this, Login.class);

            MainActivity.this.startActivity(mainIntent);

            finish();
        } else {
            // create Intent
            Intent mainIntent = new Intent(MainActivity.this, Features.class);

            MainActivity.this.startActivity(mainIntent);

            finish();
        }*/
        Intent intent = new Intent(MainActivity.this, TestByVanThiAll.class);
        MainActivity.this.startActivity(intent);
        finish();

    }
}
