package com.example.himaps;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PixelFormat;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.himaps.Model.Address;
import com.example.himaps.core.AP;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    class WifiInfo {
        public String bssid;
        public String ssid;
        public int strength;

        public WifiInfo(String bssid, String ssid, int strength) {
            this.bssid = bssid;
            this.ssid = ssid;
            this.strength = strength;
        }
    }
    List<WifiInfo> wifiList;
    WifiManager wifiManager;
    KNNAdapter adapter;
    ArrayList<AP> aps;
    BroadcastReceiver br;
    RequestQueue queue;
    private MySurfaceView surfaceView;
    Button testButton;
    Button button2;
    Button wifi;
    Button fine;
    Button course;
    class GameObject {
        private int id;
        private String username;
        private int dis;
        private float x;
        private float y;
        private Bitmap img;
        private Paint paint;
        public GameObject(){
            //this.img = BitmapFactory.decodeResource(getResources(),R.drawable.ic_md_location_on);
            this.x = -100;
            this.y = -100;
            this.paint=new Paint();
        }
        public void drawSelf(Canvas canvas){
            canvas.drawBitmap(img,x,y,paint);
        }
        public void getPos(){

        }
    }
    class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
        private Thread thread;
        private Canvas canvas;
        private SurfaceHolder surfaceHolder;
        private ArrayList<GameObject> objlist;

        public MySurfaceView(Context context) {
            super(context);
            this.setZOrderOnTop(true);//设置画布背景透明
            this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
            this.surfaceHolder=this.getHolder();
            this.surfaceHolder.addCallback(this);
            this.objlist = new ArrayList<GameObject>();
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.thread = new Thread(this);
            this.thread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }

        @Override
        public void run() {
            while(true){
                int i=0;
                while(i<objlist.size())
                {
                    GameObject obj = objlist.get(i);
                    obj.getPos();
                    canvas = this.surfaceHolder.lockCanvas();
                    obj.drawSelf(canvas);
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                    i++;
                } try {
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //surfaceView = getActivity().findViewById(R.id.surfaceView);
        testButton = getActivity().findViewById(R.id.test);
        wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        br = new BroadcastReceiver() {
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

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
                getActivity().getApplicationContext().registerReceiver(br, intentFilter);
                boolean success = wifiManager.startScan();
            }
        });
        Button button2 = getActivity().findViewById(R.id.button2);
        button2.setOnClickListener(view1 -> {
            queue = Volley.newRequestQueue(getActivity());
            StringRequest strreq = new StringRequest(Request.Method.GET, "http://52.229.167.249/getspots.php?zone=1", response -> {
                adapter = new KNNAdapter(response,aps);
                Address address = adapter.getAddress();
                Toast.makeText(getActivity(),address.toString(),Toast.LENGTH_LONG).show();
            }, error -> {
                Log.e("TAG",error.toString());
            });
            queue.add(strreq);
        });
        wifi = getActivity().findViewById(R.id.wifiPerm);
        wifi.setOnClickListener(view123 -> ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 100));
        course = getActivity().findViewById(R.id.coursePerm);
        course.setOnClickListener(view122 -> ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                100));
        fine = getActivity().findViewById(R.id.finePerm);
        fine.setOnClickListener(view124 -> ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100)
        );
    }
    private void scanSuccess() {
        List<ScanResult> results = wifiManager.getScanResults();
        aps = new ArrayList<>();
        for (ScanResult r : results) {
            //resultv.append(r.BSSID + "," + r.SSID + "," + r.level + "\n");
            aps.add(new AP(r.BSSID,r.SSID,r.level));
        }
        Toast.makeText(getActivity(), aps.size() + "APs detected.", Toast.LENGTH_SHORT).show();

    }
}