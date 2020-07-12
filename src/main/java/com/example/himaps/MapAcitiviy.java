package com.example.himaps;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MapAcitiviy extends AppCompatActivity {

    private Switch sw;
    private MySurfaceView view1;
    private TextView tdp;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        view1=(MySurfaceView)findViewById(R.id.mysurfaceview);
        tdp = findViewById(R.id.TDP);
        sw=findViewById(R.id.sw_share);

        SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());//获取当前时间
        String   str   =   formatter.format(curDate);
        tdp.setText("Time: "+ str);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if(ischecked)
                {
                    /*
                    共享用户位置
                     */
                    //重新加载surfaceview
                   // view1.setVisibility(View.GONE);
                   // view1.setVisibility(View.VISIBLE);
                }
                else{
                    /*
                    取消共享
                    */
                   // view1.setVisibility(View.GONE);
                   // view1.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
