package vn.com.gant.pifarm.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.com.gant.pifarm.R;
import vn.com.gant.pifarm.fragments.ActionBarFragment;

public class Features extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        setTitle(getString(R.string.features_title));
    }

    public void setTitle(String title){
        ActionBarFragment frmActionBar = (ActionBarFragment) this.getSupportFragmentManager().findFragmentById(R.id.actionBarFragment);
        frmActionBar.setTitleBar(title);
    }
}
