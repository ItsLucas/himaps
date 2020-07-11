package com.example.himaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondFragment extends Fragment {
    private Button btn_start;
    private ListView Inflistview;
    private ArrayList<Map<String, Object>> Infdata;

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_start = (Button) getActivity().findViewById(R.id.bt_start);
        Inflistview = (ListView) getActivity().findViewById(R.id.InflistView);


        view.findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MapAcitiviy.class));
            }
        });

        Infdata = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("dis", "距离（m)");
        item.put("name", "姓名");
        item.put("inf", "信息");
        Infdata.add(item);

        //样例
        item = new HashMap<>();
        item.put("dis", "15");
        item.put("name", "Simon");
        item.put("inf", "Friend");
        Infdata.add(item);

        showList();
    }
    private void showList(){
        SimpleAdapter listAdapter = new SimpleAdapter(getContext(), Infdata, R.layout.list_item, new String[]{"dis", "name", "inf"}, new int[]{R.id.tv_dis, R.id.tv_name, R.id.tv_phone});
        Inflistview.setAdapter(listAdapter);
    }
}
