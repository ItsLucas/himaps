package com.example.himaps;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThirdFragment extends Fragment {

    private Button btn_set,btn_add,btn_sel;
    private ListView listview;
    private ArrayList<Map<String, Object>> userdata;
    private Button btn_img;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_add=(Button)getActivity().findViewById(R.id.bt_add);
        btn_sel=(Button)getActivity().findViewById(R.id.bt_sel);
        btn_set=(Button)getActivity().findViewById(R.id.bt_setting);
        listview = (ListView)getActivity().findViewById(R.id.listView);

        userdata = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("dis","距离（m)"); item.put("name","姓名");  item.put("phone","电话");
        userdata.add(item);

        //样例
        item = new HashMap<>();
        item.put("dis","15");item.put("name","Simon");item.put("phone","15183881327");
        userdata.add(item);

        /**
         * 加载已添加联系人信息
         * **/

        showList();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String,Object>listItem=(Map<String,Object>)listview.getItemAtPosition(i);
                String telephone = (String)listItem.get("phone");
                /**
                 *
                 *与电话号码为telephone的用户聊天
                 *
                 **/
            }
        });



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add Others");

                final View v = getLayoutInflater().inflate(R.layout.dialog_add,null);
                builder.setView(v);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText editText_userphone = v.findViewById(R.id.userphone);
                        EditText editText_username = v.findViewById(R.id.username);
                        /**
                         *
                         * 添加好友
                         *
                         * **/
                        Toast.makeText(getActivity(), "Added Successfully:"+ editText_username.getText(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Change Settings");

                final View v = getLayoutInflater().inflate(R.layout.dialog_set,null);
                builder.setView(v);

                btn_img = (Button)v.findViewById(R.id.change_img);

                btn_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /***
                         * 上传图片
                         */
                        Toast.makeText(getActivity(),"Upload Your Photos ",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText editText_wifi = v.findViewById(R.id.wifi);
                        EditText editText_username = v.findViewById(R.id.username);
                        EditText editText_pwd = v.findViewById(R.id.pwd);

                        if(editText_username.getText().toString().trim()!=null)
                        {
                            /**
                             * 修改用户名
                             * */
                        }
                        if(editText_pwd.getText().toString().trim()!=null)
                        {
                            /**
                             * 修改密码
                             * */
                        }
                        if(editText_wifi.getText().toString().trim()!=null)
                        {
                            /**
                             * 修改mac地址
                             * */
                        }

                        /**
                         * if(!=null){
                         *
                         * 修改头像
                         *
                         * }*/

                        Toast.makeText(getActivity(), "Change Successfully:"+ editText_username.getText(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


        btn_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Find Someone");

                final View v = getLayoutInflater().inflate(R.layout.dialog_sel,null);
                builder.setView(v);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText editText_username = v.findViewById(R.id.username);
                        /**
                         *
                         * 查询好友
                         *
                         * **/
                        Toast.makeText(getActivity(), "Found Successfully:"+ editText_username.getText(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });

    }
    private void showList(){
        SimpleAdapter listAdapter = new SimpleAdapter(getContext(), userdata, R.layout.list_item, new String[]{"dis", "name", "phone"}, new int[]{R.id.tv_dis, R.id.tv_name, R.id.tv_phone});
        listview.setAdapter(listAdapter);
    }
/*
    public void SettingDailog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Change Settings");

        final View v = getLayoutInflater().inflate(R.layout.dialog_set,null);
        builder.setView(v);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText editText_userphone = v.findViewById(R.id.userphone);
                EditText editText_username = v.findViewById(R.id.username);
                /**
                 *
                 * 添加好友
                 *
                 * *
                Toast.makeText(getActivity(), "Added Successfully:"+ editText_username.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }
    */

}