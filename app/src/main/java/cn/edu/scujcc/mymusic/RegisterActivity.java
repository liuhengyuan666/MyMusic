package cn.edu.scujcc.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private Button registerButton;
    private UserLab lab = UserLab.getInstance();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg != null){
                switch (msg.what){
                    case UserLab.USER_REGISTER_SUCCESS:
                        Toast.makeText(RegisterActivity.this,"注册成功！动听音乐欢迎您的加入！",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                        break;
                    case UserLab.USER_REGISTER_FAIL:
                        Toast.makeText(RegisterActivity.this,"注册失败！",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> {
            register();
        });
    }

    private void register() {
        User u = new User();
        int what = 1;
        boolean error = false;
        String errorMessage;
        //用户名
        EditText usernameInput = findViewById(R.id.r_username);
        Editable username = usernameInput.getText();
        //TODO 修改判断方式 EditText不能用null
        u.setUsername(!username.toString().equals("") ? username.toString() : "");

        //密码
        EditText passwordInput1 = findViewById(R.id.Password);
        EditText passwordInput2 = findViewById(R.id.r_password2);
        Editable password1 = passwordInput1.getText();//edittext 不能用null判断
        Editable password2 = passwordInput2.getText();
        if (!password1.toString().equals("") && !password2.toString().equals("")) {
            if (!password2.toString().equals(password1.toString())) { //两次密码不相同
                what = 2;
                Toast.makeText(RegisterActivity.this,"注册失败，两次密码不相同",Toast.LENGTH_LONG).show();
                error = true;
                errorMessage = "两次密码不相同";
            } else {
                u.setPassword(password1.toString());
            }
        }
        //手机号
        EditText phoneInput =findViewById(R.id.r_phone);
        Editable phone = phoneInput.getText();
        u.setPhone(!phone.toString().equals("") ? phone.toString() : "");

        //性别
        RadioGroup genderGroup = findViewById(R.id.r_gender);
        int gender = genderGroup.getCheckedRadioButtonId();
        switch (gender) {
            case R.id.r_male:
                u.setGender("男");
                break;
            case R.id.r_female:
                u.setGender("女");
                break;
            default:
                u.setGender("保密");
        }

        //本地判断测试
        switch (what){
             case 1:
                 lab.register(u, handler);
       }
    }
}
