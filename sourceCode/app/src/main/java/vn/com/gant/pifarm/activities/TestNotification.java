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
    NotificationObject notificationObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification);
        txtDate = (EditText) findViewById(R.id.edtDateTest);
        txtNotification = (EditText) findViewById(R.id.edtNotificationTest);
        btAdd = (Button) findViewById(R.id.btAddTest);
        notificationModel = new NotificationModel(this);
        notificationObject=new NotificationObject(DateHanding.getDate("12-12-12-12"),"dep") ;
    }

    public void addOnClick(View view) {
        String date = txtDate.getText().toString();
        String notification = txtDate.getText().toString();
        //txtNotification.setText(DateHanding.getDateString(date));
      // List<String[]> data = notificationModel.getNotificationByDate(date);
//       if(data.isEmpty()){
//           txtNotification.setText("ko co");
//       }
//        else
//       txtNotification.setText(data.get(0)[1].toString());
//        notificationModel.remove("13-13-1313");
       notificationModel.add(date,notification);


    }
}

