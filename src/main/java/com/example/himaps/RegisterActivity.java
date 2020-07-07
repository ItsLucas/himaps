package com.example.himaps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;//注册按钮

    private EditText et_user_name,et_psw,et_user_phone;
    private String userName,psw,userPhone;
    public static RequestQueue requestQueue;
    private void volleyGetRequestregister(String s1,String s2,String s3) {
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest;
        stringRequest = new StringRequest("http://52.229.167.249/reg.php?user="+s1+"&pass="+s2+"&phone="+s3, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("--get--", "onResponse: " + s);
                if(s.equals("Success"))Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();//判断连接是否成功
                    ///注册成功添加跳转页面
                else {Toast.makeText(RegisterActivity.this,"failed",Toast.LENGTH_SHORT).show();return;};
                Toast.makeText(RegisterActivity.this, s,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.i("--get--", "onResponse: " + e);

            }
        });
        requestQueue.add(stringRequest);
    }

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
                Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
                Matcher m = p.matcher(userName);
                boolean fl= m.matches();
                Pattern p2 = Pattern.compile("^[0-9]*[1-9][0-9]*$");
                Matcher m2 = p2.matcher(psw);
                boolean f2= m2.matches();
                if(userPhone.length()!=11)
                {et_user_phone.setError("the number of phone must be 13");return;}
                if (userName.equals("")) {
                    Toast.makeText(RegisterActivity.this,"please input user-name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (fl == false) {
                    Toast.makeText(RegisterActivity.this, "please input correct user-name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userPhone.equals("")) {
                    Toast.makeText(RegisterActivity.this,"please input phone-number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(psw.equals(""))
                {Toast.makeText(RegisterActivity.this,"password is empty",Toast.LENGTH_SHORT).show();return;}
                if (f2 == false) {
                    Toast.makeText(RegisterActivity.this, "please input correct password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(psw.length() < 6) {
                    et_psw.setError("the number must be over 6");return;
                }
                volleyGetRequestregister(userName,psw,userPhone);
            }
        });
    }
    private void getEditString(){
        userPhone=et_user_phone.getText().toString().trim();
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
    }
}
