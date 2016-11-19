package vn.com.gant.pifarm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import vn.com.gant.pifarm.ImageAdapter;
import vn.com.gant.pifarm.R;
import vn.com.gant.pifarm.SaveSharedPreference;
import vn.com.gant.pifarm.fragments.ActionBarFragment;

public class Features extends AppCompatActivity {

    GridView gridView;
    static final String[] features = new String[]{
            "Đọc thẻ", "Ghi thẻ", "Quản lý heo", "Thuốc và vaccine", "Thống kê",
            "Hỏi đáp", "Quản lý nhân viên", "Đồng bộ dữ liệu", "Đăng xuất"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        String title = getString(R.string.features_title);

        ActionBarFragment frmActionBar = (ActionBarFragment) this.getSupportFragmentManager().findFragmentById(R.id.actionBarFragment);
        frmActionBar.setTitleBar(title);

        gridView = (GridView) findViewById(R.id.gridFeatures);

        gridView.setAdapter(new ImageAdapter(this, features));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = (String) ((TextView) view.findViewById(R.id.grid_item_label)).getText();
                switch (title){
                    case "Đọc thẻ":
                        derectTo(ReadCard.class);
                        break;
                    case "Ghi thẻ":
                        derectTo(WriteCard.class);
                        break;
                    case "Quản lý heo":
                        derectTo(ManageSwine.class);
                        break;
                    case "Thuốc và vaccine":
                        derectTo(Vaccines.class);
                        break;
                    case "Thống kê":
                        derectTo(Statictis.class);
                        break;
                    case "Hỏi đáp":
                        derectTo(Forum.class);
                        break;
                    case "Quản lý nhân viên":
                        derectTo(ManageStaffs.class);
                        break;
                    case "Đồng bộ dữ liệu":
                        derectTo(SyncData.class);
                        break;
                    case "Đăng xuất":
                        SaveSharedPreference.setUserName(Features.this, "");
                        derectTo(Login.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void derectTo(Class derection){
        Intent container = new Intent(this, derection);
        this.startActivity(container);
        this.finish();
    }
}
