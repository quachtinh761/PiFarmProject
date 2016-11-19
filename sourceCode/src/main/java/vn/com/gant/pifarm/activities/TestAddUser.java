package vn.com.gant.pifarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import function.DateHanding;
import models.NotificationModel;
import models.UserModel;
import objects.NotificationObject;

public class TestAddUser extends AppCompatActivity {
    EditText txtDate;
    EditText txtNotification;
    Button   btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_add_user);

        txtDate = (EditText)findViewById(R.id.edtUserTest);
        txtNotification = (EditText)findViewById(R.id.edtPassTest);
        btAdd = (Button)findViewById(R.id.btAddTest);

    }
    public void addOnClick(){
        Date date = DateHanding.getDate(txtDate.getText().toString());
        String strNotification=txtNotification.getText().toString();
        NotificationModel notificationModel =new NotificationModel(this);
        NotificationObject notificationObject=new NotificationObject(date,strNotification);
        notificationModel.add(notificationObject);
    }
}
