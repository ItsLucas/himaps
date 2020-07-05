package com.example.himaps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;//注册按钮

    private EditText et_user_name,et_psw,et_user_phone;
    private String userName,psw,userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_psw=(EditText)findViewById(R.id.et_psw);
        et_user_name=(EditText)findViewById(R.id.et_user_name);
        et_user_phone=(EditText)findViewById(R.id.et_user_phone);

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditString();
                //判断输入框内容
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(getApplicationContext(),"请输入用户名",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(getApplicationContext(),"请输入密码",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(userPhone)){
                    Toast.makeText(getApplicationContext(),"请输入手机号",Toast.LENGTH_SHORT).show();
                }
                else {
                    /***
                     *
                     * 验证注册信息
                     *
                     * **/
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("id",1);
                    startActivity(intent);
                }
            }
        });
    }
    private void getEditString(){
        userPhone=et_user_phone.getText().toString().trim();
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
    }
}
