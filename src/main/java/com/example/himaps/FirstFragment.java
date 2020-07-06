package com.example.himaps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private Button btn_register;//注册按钮
    private Button btn_login;//登录按钮
    private EditText et_user_name,et_psw;
    private String userName,psw;
    //用户名，密码的控件及其获取值
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_psw=(EditText)getActivity().findViewById(R.id.et_psw);
        et_user_name=(EditText)getActivity().findViewById(R.id.et_user_name);

        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),RegisterActivity.class));
            }
        });

        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditString();
                //判断输入框内容
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(getActivity(),"请输入用户名",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(getActivity(),"请输入密码",Toast.LENGTH_SHORT).show();
                }
                else {
                    /***
                     *
                     * 验证登录信息
                     *
                     * **/
                    Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    private void getEditString(){
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
    }
}