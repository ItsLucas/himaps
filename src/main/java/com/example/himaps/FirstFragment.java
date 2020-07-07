package com.example.himaps;

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
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_second,new SecondFragment())
                            .addToBackStack(null)
                            .commit();
                }
                Toast.makeText(getActivity(), s,Toast.LENGTH_SHORT).show();}
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

    }

}