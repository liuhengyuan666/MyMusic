package cn.edu.scujcc.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private final static String TAG = "DianDian";
    private EditText username,password;
    private String user;
    private Button loginButton,registerButton;
    private UserLab lab = UserLab.getInstance();
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case UserLab.USER_LOGIN_SUCCESS:
                    loginSuccess(msg.obj);
                    break;
                case UserLab.USER_LOGIN_FAIL:
                    loginFail();
                    break;
                case UserLab.USER_LOGIN_PASSWORD_ERROR:
                    loginPasswordError();;
                    break;
            }
        }
    };

    private void loginSuccess(Object token){
        Toast.makeText(LoginActivity.this,"登录成功!",Toast.LENGTH_LONG).show();
        prefs.saveUser(user, (String) token);
        Log.d(TAG, "用户"+user+"登录成功,token="+token);
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);//返回主页面
        startActivity(intent);
    }

    private void loginFail(){
        Toast.makeText(LoginActivity.this,"登录失败!",Toast.LENGTH_LONG).show();
    }

    private void loginPasswordError(){
        Toast.makeText(LoginActivity.this,"密码错误,请重试!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs.setup(getApplicationContext());

        username = findViewById(R.id.r_username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            user = username.getEditText().getText().toString();
            String p = password.getEditText().getText().toString();
            lab.login(user,p,handler);
        });

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });

        prefs.setup(getApplicationContext());
        //prefs.setup(this);
    }
//    private Button register_button;
//    private Button login_button;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        register_button= (Button) findViewById(R.id.register_button);
//        register_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
//        login_button= (Button) findViewById(R.id.login_button);
//        login_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });


    }

}