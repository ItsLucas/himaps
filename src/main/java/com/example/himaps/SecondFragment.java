package com.example.himaps;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {



    private MySurfaceView view1;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

    //    return new MySurfaceView(getActivity().getApplicationContext());

        return inflater.inflate(R.layout.fragment_second, container, false);

  }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setContentView(R.layout.fragment_second);
        view1 = (MySurfaceView)getActivity().findViewById(R.id.mysurfaceview);
    }


}
/*
testButton = (Button)getActivity().findViewById(R.id.test);
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
            StringRequest strreq = new StringRequest(Request.Method.GET, "http://52.229.167.249/getspots.php?zone=2", response -> {
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
 */