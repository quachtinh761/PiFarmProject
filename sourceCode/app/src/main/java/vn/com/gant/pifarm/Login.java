package vn.com.gant.pifarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    public static final String TAG = "LoginMessages";
    EditText etxtEmail;
    EditText etxtPass;
    Button btnLogin;
    TextView txvForgotPass;
    ImageButton ibtnFacebook;
    ImageButton ibtnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.i(TAG, "onCreate: done");

        // attach to layout element
        etxtEmail = (EditText)findViewById(R.id.edtMail);
        etxtPass = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        ibtnFacebook = (ImageButton)findViewById(R.id.ibtnFacebook);
        ibtnGoogle = (ImageButton)findViewById(R.id.ibtnGoogle);
        txvForgotPass = (TextView)findViewById(R.id.txvForgotPass);

        // set manager for element
        etxtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: done");
            }
        });
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"destroy");
    }
}
