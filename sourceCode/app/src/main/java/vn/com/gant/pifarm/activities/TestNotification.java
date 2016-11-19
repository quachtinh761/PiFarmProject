package vn.com.gant.pifarm.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.DateHanding;
import models.BaseModel;
import models.NotificationModel;
import objects.NotificationObject;
import vn.com.gant.pifarm.R;

public class TestNotification extends AppCompatActivity {
    EditText txtDate;
    EditText txtNotification;
    Button btAdd;
    NotificationModel notificationModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification);
        txtDate = (EditText)findViewById(R.id.edtDateTest);
        txtNotification = (EditText)findViewById(R.id.edtNotificationTest);
        btAdd = (Button)findViewById(R.id.btAddTest);
        notificationModel= new NotificationModel(this);
    }
    public void addOnClick(){
        String date= txtDate.getText().toString();
        List<String[]> data=notificationModel.getNotificationByDate(date);
        txtNotification.setText(data.get(0)[1].toString());
    }
}
