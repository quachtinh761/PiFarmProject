package vn.com.gant.pifarm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import models.UserModel;
import vn.com.gant.pifarm.R;
import vn.com.gant.pifarm.SaveSharedPreference;

public class Login extends AppCompatActivity {

    public static final String TAG = "LoginMessages";
    private EditText etxtEmail;
    private EditText etxtPass;
    private Button btnLogin;
    private TextView txvForgotPass;
    private ImageButton ibtnFacebook;
    private ImageButton ibtnGoogle;
    private RelativeLayout background;
    private ImageView logo;
    private String userName = "";
    private String pass = "";
    UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user =new UserModel(this);

//        Log.i(TAG, "onCreate: done");

        // attach to layout element
        etxtEmail = (EditText)findViewById(R.id.edtMail);
        etxtPass = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        ibtnFacebook = (ImageButton)findViewById(R.id.ibtnFacebook);
        ibtnGoogle = (ImageButton)findViewById(R.id.ibtnGoogle);
        txvForgotPass = (TextView)findViewById(R.id.txvForgotPass);
        background = (RelativeLayout)findViewById(R.id.activity_login);
        logo = (ImageView)findViewById(R.id.imgLogo);

        // set manager for element
        etxtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    etxtEmail.setHint("");
                    showKeyBoard();
                } else {
                    if(etxtEmail.getText().length()==0){
                        etxtEmail.setHint(R.string.exampleEmail);
                    }
                    hideKeyBoard();
                }
            }
        });

        etxtPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    etxtPass.setHint("");
                    showKeyBoard();
                } else {
                    if(etxtPass.getText().length()==0){
                        etxtPass.setHint(R.string.password);
                    }
                    hideKeyBoard();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etxtEmail.getText().toString();
                pass = etxtPass.getText().toString();
                if (checkLogin(userName, pass)){
                    SaveSharedPreference.setUserName(Login.this, userName);
                    Intent loginIntent = new Intent(Login.this, Features.class);
                    Login.this.startActivity(loginIntent);
//                    String text = SaveSharedPreference.getUserName(Login.this).toString();
//                    Log.i(TAG, text);
//                    Log.i(TAG, "login is true");
                    finish();
                } else {
                    etxtEmail.setText("");
                    etxtPass.setText("");
                    etxtEmail.setHint(R.string.exampleEmail);
                    etxtPass.setHint(R.string.password);
                    Toast.makeText(Login.this, getString(R.string.failLoginMessage), Toast.LENGTH_SHORT).show();
//                    Log.i(TAG, "login is false");
                }
            }
        });

        txvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Login.this, ForgotPass.class);
                Login.this.startActivity(loginIntent);
                finish();
            }
        });

        ibtnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Login.this, GoogleConnector.class);
                Login.this.startActivity(loginIntent);
                finish();
            }
        });

        ibtnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Login.this, FacebookConnector.class);
                Login.this.startActivity(loginIntent);
                finish();
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard();
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Login.this, Introduction.class);
                Login.this.startActivity(loginIntent);
                finish();
            }
        });
    }

    public void showKeyBoard(){
        InputMethodManager imng = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imng.showSoftInput(etxtEmail, InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideKeyBoard(){
        InputMethodManager imng = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imng.hideSoftInputFromWindow(background.getWindowToken(), 0);
    }

    public void onDestroy(){
        super.onDestroy();
    }

    public boolean checkLogin(String userName, String pass){
        List<String[]> data = user.getUserByUserName(userName);
        if (data.isEmpty()){
            return false;

        }else{
            if (userName.equals(data.get(0)[0]) && pass.equals(data.get(0)[1])){
                return true;
            }else{
                return false;
            }
        }
    }

    public void saveUserInfoToReference(String userName, String pass){

    }
}
