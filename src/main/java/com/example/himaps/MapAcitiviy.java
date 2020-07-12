package com.example.himaps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.himaps.Model.UserData;
import com.example.himaps.core.AP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapAcitiviy extends AppCompatActivity {

    private Switch sw;
    private MySurfaceView view1;
    private TextView tdp;
    private WifiManager wifiManager;
    private BroadcastReceiver br;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        UserDataStorage.stopThread=false;
        view1=(MySurfaceView)findViewById(R.id.mysurfaceview);
        tdp = findViewById(R.id.TDP);
        sw=findViewById(R.id.sw_share);
        sw.setOnCheckedChangeListener((compoundButton, b) -> UserDataStorage.vanish = !b);
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
        UserDataStorage.wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        UserDataStorage.br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean success = intent.getBooleanExtra(
                        WifiManager.EXTRA_RESULTS_UPDATED, false);
                if (success) {
                    scanSuccess();
                } else {
                    // scan failure handling
                }
            }

        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserDataStorage.stopThread=true;
        unregisterReceiver(UserDataStorage.br);
    }
    private void scanSuccess() {
        List<ScanResult> results = UserDataStorage.wifiManager.getScanResults();
        UserDataStorage.aps = new ArrayList<>();
        for (ScanResult r : results) {
            //resultv.append(r.BSSID + "," + r.SSID + "," + r.level + "\n");
            UserDataStorage.aps.add(new AP(r.BSSID,r.SSID,r.level));
        }
        //Toast.makeText(getActivity(), aps.size() + "APs detected.", Toast.LENGTH_SHORT).show();

    }
}
