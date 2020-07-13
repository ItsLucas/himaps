package com.example.himaps;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.util.Log;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.himaps.Model.UserData;
import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdFragment extends Fragment {

    private Button btn_set, btn_add, btn_sel;
    private ListView listview;
    private ArrayList<Map<String, Object>> userdata;
    private Button btn_img;
    private RequestQueue queue;
    private FriendData data;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        queue = Volley.newRequestQueue(getActivity());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    private void volleyGetRequestFriend(String s1) {
        StringRequest stringRequest;
        //Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();
        stringRequest = new StringRequest("http://52.229.167.249/getfriend.php?user=" + s1, s -> {
            data = new Gson().fromJson(s, FriendData.class);
            if (data == null) return;
            for (Friend x : data.data) {
                Map<String, Object> item = new HashMap<>();
                item.put("dis", "15");
                item.put("name", x.name);
                item.put("phone", x.phone);
                if (!userdata.contains(item))
                    userdata.add(item);
            }
            /**
             * 加载已添加联系人信息
             * **/

            showList();
        }, e -> Log.i("--get--", "onResponse: " + e));
        queue.add(stringRequest);
    }

    private void volleyGetRequestAddFriend(String s1) {
        StringRequest stringRequest;
        //Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();
        stringRequest = new StringRequest("http://52.229.167.249/addfriend.php?uuid=" + UserDataStorage.data.getuuid()
                + "&user=" + UserDataStorage.data.getname() + "&friend=" + s1, s -> {
            Toast.makeText(getActivity(), "Added Successfully:" + s1, Toast.LENGTH_SHORT).show();
            //样例
            volleyGetRequestFriend(UserDataStorage.data.getname());


        }, e -> Log.i("--get--", "onResponse: " + e));
        queue.add(stringRequest);
    }

    private void volleyGetRequestChangeUser(String s1, String s2, String s3) {
        StringRequest stringRequest;
        //Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();
        stringRequest = new StringRequest("http://52.229.167.249/changebyuuid.php?uuid=" + UserDataStorage.data.getuuid()
                + "&user=" + UserDataStorage.data.getname() + "&pass=" + s2 + "&phone=" + s3, s -> {
            Log.i("--get--", "onResponse: " + s);
            Toast.makeText(getActivity(), "Changed Successfully:" + s1, Toast.LENGTH_SHORT).show();
            new Thread(() -> {
                try {
                    EMClient.getInstance().createAccount(s1,s2);
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }).start();

        }, e -> Log.i("--get--", "onResponse: " + e));
        queue.add(stringRequest);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserDataStorage.stopThread = true;
        btn_add = (Button) getActivity().findViewById(R.id.bt_add);
        btn_sel = (Button) getActivity().findViewById(R.id.bt_sel);
        btn_set = (Button) getActivity().findViewById(R.id.bt_setting);
        listview = (ListView) getActivity().findViewById(R.id.listView);

        userdata = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        volleyGetRequestFriend(UserDataStorage.data.getname());

        item.put("dis", "距离（m)");
        item.put("name", "姓名");
        item.put("phone", "电话");
        userdata.add(item);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> listItem = (Map<String, Object>) listview.getItemAtPosition(i);
                String telephone = (String) listItem.get("name");
                Intent in = new Intent(getActivity(), ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", "me");
                bundle.putBoolean("isroom", false);
                bundle.putString("oppo", telephone);
                in.putExtras(bundle);
                startActivity(in);
            }
        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add Others");

                final View v = getLayoutInflater().inflate(R.layout.dialog_add, null);
                builder.setView(v);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText editText_userphone = v.findViewById(R.id.userphone);
                        EditText editText_username = v.findViewById(R.id.username);
                        volleyGetRequestAddFriend(editText_username.getText().toString());
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

                final View v = getLayoutInflater().inflate(R.layout.dialog_set, null);
                builder.setView(v);

                btn_img = (Button) v.findViewById(R.id.change_img);

                btn_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /***
                         * 上传图片
                         */
                        Toast.makeText(getActivity(), "Upload Your Photos ", Toast.LENGTH_SHORT).show();
                    }
                });
                EditText editText_wifi = v.findViewById(R.id.wifi);
                EditText editText_username = v.findViewById(R.id.username);
                EditText editText_pwd = v.findViewById(R.id.pwd);
                editText_username.setText(UserDataStorage.data.getname());

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userName = editText_username.getText().toString().trim();
                        String psw = editText_pwd.getText().toString().trim();
                        String userPhone = editText_wifi.getText().toString().trim();
                        Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
                        Matcher m = p.matcher(userName);
                        boolean fl = m.matches();
                        Pattern p2 = Pattern.compile("^[0-9]*[1-9][0-9]*$");
                        Matcher m2 = p2.matcher(psw);
                        boolean f2 = m2.matches();
                        if (userPhone.length() != 11) {
                            editText_wifi.setError("the number of phone must be 13");
                            Toast.makeText(getActivity(), "the number of phone must be 13", Toast.LENGTH_SHORT).show();

                            return;
                        }
                        if (userName.equals("")) {
                            Toast.makeText(getActivity(), "please input user-name", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (fl == false) {
                            Toast.makeText(getActivity(), "please input correct user-name", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (userPhone.equals("")) {
                            Toast.makeText(getActivity(), "please input phone-number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (psw.equals("")) {
                            Toast.makeText(getActivity(), "password is empty", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (f2 == false) {
                            Toast.makeText(getActivity(), "please input correct password", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (psw.length() < 6) {
                            Toast.makeText(getActivity(), "password length must exceed 6", Toast.LENGTH_SHORT).show();

                            editText_pwd.setError("the number must be over 6");
                            return;
                        }
                        volleyGetRequestChangeUser(userName,psw,userPhone);
                        Toast.makeText(getActivity(), "Change Successfully:" + editText_username.getText(), Toast.LENGTH_SHORT).show();
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

                if(UserDataStorage.curx<=2.1f&&UserDataStorage.cury<=2.1f) {
                    Intent in = new Intent(getActivity(), ChatActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", UserDataStorage.data.getname());
                    bundle.putBoolean("isroom", true);
                    in.putExtras(bundle);
                    startActivity(in);
                }
                else {
                    Toast.makeText(getActivity(), "Not in vzone!", Toast.LENGTH_SHORT).show();
                }
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Find Someone");

                final View v = getLayoutInflater().inflate(R.layout.dialog_sel, null);
                builder.setView(v);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText editText_username = v.findViewById(R.id.username);
                        Toast.makeText(getActivity(), "Found Successfully:" + editText_username.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

                 */
            }
        });

    }

    private void showList() {
        SimpleAdapter listAdapter = new SimpleAdapter(getContext(), userdata, R.layout.list_item, new String[]{"dis", "name", "phone"}, new int[]{R.id.tv_dis, R.id.tv_name, R.id.tv_phone});
        listview.setAdapter(listAdapter);
    }

    class Friend {
        public String name;
        public String phone;

        public Friend(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    class FriendData {
        public ArrayList<Friend> data;

        public FriendData(ArrayList<Friend> data) {
            this.data = data;
        }
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