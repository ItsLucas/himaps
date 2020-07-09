package com.example.himaps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.himaps.Model.UserData;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private Button btn_register;//register钮
    private EditText textname;
    private String name;
    private EditText textpassd;
    private String passd;
    private UserData u;
    public static RequestQueue requestQueue;

    private void volleyGetRequest(String s1,String s2) {
        requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest;
        stringRequest = new StringRequest("http://52.229.167.249/login.php?user="+s1+"&pass="+s2, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("--get--", "onResponse: " + s);
                if(s.equals("Username or Password wrong"))
                {Toast.makeText(getActivity(), "login failed", Toast.LENGTH_SHORT).show();}

                else {Toast.makeText(getActivity(),"login success",Toast.LENGTH_SHORT).show();

                textpassd.setVisibility(View.GONE);
                getView().findViewById(R.id.btn_register).setVisibility(View.GONE);
                getView().findViewById(R.id.btn_login).setVisibility(View.GONE);
                /*

                login success,then enter other interface

                 */
                    u= new UserData();
                    u.setuuid(s);
                    u.setpaw(s2);
                    u.setname(s1);
                    EMClient.getInstance().login(s1, s2, new EMCallBack() {
                        @Override
                        public void onSuccess() {
                            EMClient.getInstance().groupManager().loadAllGroups();
                            EMClient.getInstance().chatManager().loadAllConversations();
                            Log.i("IM","IM Server logged in. User: "+s1);
                        }

                        @Override
                        public void onError(int code, String error) {

                        }

                        @Override
                        public void onProgress(int progress, String status) {

                        }
                    });
                }

                //Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();
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
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enter the register interface(add a phone edit text)调
            }
        });
        textname=(EditText) view.findViewById(R.id.et_user_name);
        textpassd=(EditText) view.findViewById(R.id.et_psw);
        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),RegisterActivity.class));
            }
        });
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = textname.getText().toString().trim();
                passd = textpassd.getText().toString().trim();
                Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
                Matcher m = p.matcher(name);
                boolean fl= m.matches();
                if (name.equals("")) {
                    Toast.makeText(getActivity(),"please input user-name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (fl == false) {
                    Toast.makeText(getActivity(), "Please input correct user-name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passd.equals(""))
                {Toast.makeText(getActivity(),"the password is empty",Toast.LENGTH_SHORT).show();return;}
                if(passd.trim().length() < 6)
                {textpassd.setError("the number must be over 6");return;}
                volleyGetRequest(name,passd);
            }
        });
        view.findViewById(R.id.button).setOnClickListener(view1 -> {
            Intent in = new Intent(getActivity(),ChatActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("user",u.getname());
            in.putExtras(bundle);
            startActivity(in);
        });

    }

}