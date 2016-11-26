package controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import models.UserModel;
import objects.userObject;
import vn.com.gant.pifarm.R;


/**
 * Created by Nguyen Van Tinh on 23/10/2016.
 */
public class UserController extends Activity{
    EditText txtEmail;
    EditText txtPass;
    EditText txtConfirmPass;
    TextView lblMessage;
    Button btnRegister;
    UserModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_member);
        lblMessage = (TextView)findViewById(R.id.txtMessage);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPass = (EditText)findViewById(R.id.txtPassword);
        txtConfirmPass = (EditText)findViewById(R.id.txtConfirmPassword);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        model = new UserModel(this);
    }

    public boolean btnRegisterClick(View view){
        lblMessage.setText(model.isTableExist() + "");
        return true;//model.createTableUser();
        /*String user = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();
        String confirmPass = txtConfirmPass.getText().toString();
        if (user.equals("")){
            lblMessage.setText("User email is not empty.");

            return false;
        }

        List<String[]> users = model.getUserByUserName(user);
        if (users.size() > 0){
            lblMessage.setText("User has already existed.");
            return false;
        }

        if (!pass.equals(confirmPass)){
            lblMessage.setText("Password and re-typed password do not match.");
            return false;
        }
        userObject us = new userObject(user, pass, "", "", null, "", "12345678", "2");
        if (us.checkIsValidUser()){
            model.addUser(us);
        }
        List<String[]> list_users = new ArrayList<>();
        list_users = model.getUserByUserName(user);
        lblMessage.setText(list_users.size() + "");
        return true;*/
    }


}
