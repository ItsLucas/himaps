package com.example.himaps;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ThirdFragment extends Fragment {

    private Button btn_set;
    private Button btn_del,btn_add,btn_sel;
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

        //btn_add=(Button)getActivity().findViewById(R.id.bt_add);
        //btn_del=(Button)getActivity().findViewById(R.id.bt_del);
        //btn_sel=(Button)getActivity().findViewById(R.id.bt_sel);
        //btn_set=(Button)getActivity().findViewById(R.id.bt_setting);
        //listview = (ListView)getActivity().findViewById(R.id.listView);

        //btn_add.setOnClickListener(v -> startActivity(new Intent(getActivity(),AddActivity.class)));

    }
}