package vn.com.gant.pifarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.gant.pifarm.activities.TestChildProModel;

public class TestByVanThiAll extends AppCompatActivity {
    Button btnChildPro, btnParenPro, btnParentSw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_by_van_thi_all);
        btnChildPro = (Button) findViewById(R.id.btnChildProcess);
        btnParenPro = (Button) findViewById(R.id.btnParentProcess);
        btnParentSw = (Button) findViewById(R.id.btnParentSw);

        btnChildPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestByVanThiAll.this, TestChildProModel.class);
                TestByVanThiAll.this.startActivity(intent);
                finish();
            }
        });

        btnParenPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestByVanThiAll.this, TestParentProcess.class);
                TestByVanThiAll.this.startActivity(intent);
                finish();
            }
        });

        btnParentSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestByVanThiAll.this, TestParentSwine.class);
                TestByVanThiAll.this.startActivity(intent);
                finish();
            }
        });
    }
}
