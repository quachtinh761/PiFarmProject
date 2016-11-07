package vn.com.gant.pifarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        
    }
}
