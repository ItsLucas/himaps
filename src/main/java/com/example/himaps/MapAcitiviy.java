package com.example.himaps;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MapAcitiviy extends AppCompatActivity {

    private MySurfaceView view1;
    private TextView tdp;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        view1=(MySurfaceView)findViewById(R.id.mysurfaceview);
        tdp = findViewById(R.id.TDP);

        SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());//获取当前时间

        String   str   =   formatter.format(curDate);

        tdp.setText("Time: "+ str);
    }
}
