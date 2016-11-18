package controllers;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import models.UserModel;
import vn.com.gant.pifarm.FacebookConnector;
import vn.com.gant.pifarm.Features;
import vn.com.gant.pifarm.ForgotPass;
import vn.com.gant.pifarm.GoogleConnector;
import vn.com.gant.pifarm.Introduction;
import vn.com.gant.pifarm.Login;
import vn.com.gant.pifarm.R;
import vn.com.gant.pifarm.SaveSharedPreference;

/**
 * Created by Nguyen Van Tinh on 23/10/2016.
 */
public class LoginController extends Activity{
    EditText txtEmail;
    EditText txtPass;
    Button btnLogin;
    UserModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail = (EditText)findViewById(R.id.edtMail);
        txtPass = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        model = new UserModel(this);
    }

    public void btnLoginClick(View view){
        String mail = txtEmail.getText().toString();
        String psw = txtPass.getText().toString();
        List<String[]> data = model.getUserByUserName(mail);
        if (data.size() == 0){
            txtEmail.setText("User is not exist");
        }else{
            if (mail.equals(data.get(0)[0]) && psw.equals(data.get(0)[1])){
                txtEmail.setText("Login Failure");
            }else{
                txtEmail.setText("Login Failure");
            }
        }
    }
}
