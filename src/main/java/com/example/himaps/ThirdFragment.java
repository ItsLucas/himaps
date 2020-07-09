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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ThirdFragment extends Fragment {

    private Button btn_set,btn_add,btn_sel;
    private ListView listview;

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

        btn_add=(Button)getActivity().findViewById(R.id.bt_add);
        btn_sel=(Button)getActivity().findViewById(R.id.bt_sel);
        btn_set=(Button)getActivity().findViewById(R.id.bt_setting);
        listview = (ListView)getActivity().findViewById(R.id.listView);
    }
    
    public void AddDialog(View view){
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
}