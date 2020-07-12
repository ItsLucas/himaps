package com.example.himaps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.himaps.Model.Address;
import com.example.himaps.core.AP;

import java.util.ArrayList;
import java.util.List;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    private Thread thread;
    private Paint paint;
    private Context context;
    private Canvas canvasobj,canvasmap;
    private SurfaceHolder surfaceHolder;
    private ArrayList<GameObject> objlist;
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
    class GameObject {
        private int id;
        private String username;
        private int dis;
        private float x;
        private float y;
        private Bitmap img;
        private Paint paint;
        //paint.setAlpha(150);
        public GameObject(){
            //this.img = BitmapFactory.decodeResource(getResources(),R.drawable.ic_md_location_on);
            this.img = drawableToBitmap(ContextCompat.getDrawable(context,R.drawable.ic_md_location_on));
            this.x = 300;
            this.y = 300;
            this.paint=new Paint();
        }public GameObject(float x,float y){
            //this.img = BitmapFactory.decodeResource(getResources(),R.drawable.ic_md_location_on);
            this.img = drawableToBitmap(ContextCompat.getDrawable(context,R.drawable.ic_md_location_on));
            this.x = x;
            this.y = y;
            this.paint=new Paint();
        }
        public void drawSelf(Canvas canvas){
            canvas.drawBitmap(img,x,y,paint);
        }
        public void getPos(){
            x=310;
            y=310;
        }
        public Bitmap drawableToBitmap (Drawable drawable) {

            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable)drawable).getBitmap();
            }

            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);

            return bitmap;
        }
    }
    List<WifiInfo> wifiList;
    WifiManager wifiManager;
    KNNAdapter adapter;
    ArrayList<AP> aps;
    BroadcastReceiver br;
    RequestQueue queue;
    Button testButton;
    Button button2;
    Button wifi;
    Button fine;
    Button course;
    String resp;
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context=context;
        this.setKeepScreenOn(true);
        this.setZOrderOnTop(true);
        this.setZOrderMediaOverlay(true);
        this.getHolder().setFormat(PixelFormat.TRANSPARENT);

        this.surfaceHolder=this.getHolder();
        this.surfaceHolder.addCallback(this);
        this.objlist = new ArrayList<GameObject>();
/**
 RelativeLayout.LayoutParams params  =
 new RelativeLayout.LayoutParams(100, 100);

 params.leftMargin = 500;
 params.topMargin  = -30;

 this.setLayoutParams(params);
 **/       }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.thread = new Thread(this);

        Toast.makeText(context,"Starting thread",Toast.LENGTH_SHORT).show();
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
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
        queue = Volley.newRequestQueue(context);
        StringRequest strreq = new StringRequest(Request.Method.GET, "http://52.229.167.249/getspots.php?zone=3", response -> {
            resp=response;
            Log.i("NETWORK","Got response from server");
        }, error -> {
            Log.e("TAG",error.toString());
        });
        queue.add(strreq);
        this.thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
    public Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
    @Override
    public void run() {
        Bitmap bitmap=drawableToBitmap(getResources().getDrawable(R.drawable.ic_map));
        Rect rect = new Rect(0, 0,3280 , 2560);//地图填充的矩形范围
        RectF rectf = new RectF(0, 0, 1500,3000 );//地图放置的位置
        canvasmap = this.surfaceHolder.lockCanvas();
        canvasmap.drawColor(Color.WHITE);//设置画布底色
        canvasmap.drawBitmap(bitmap,rect,rectf,paint);
        this.surfaceHolder.unlockCanvasAndPost(canvasmap);
        objlist.add(new GameObject(1000.0f,1500.0f));
        objlist.add(new GameObject(1000.0f,1000.0f));
        GameObject genobj = new GameObject(1000.0f,100000.0f);
        while(true) {
            int i = 0;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
           context.registerReceiver(br, intentFilter);
            boolean success = wifiManager.startScan();
            if (success&&aps!=null) {
                canvasobj = this.surfaceHolder.lockCanvas();
                canvasobj.drawBitmap(bitmap, rect, rectf, paint);
                canvasobj.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//设置画布透明
                //while(i<objlist.size())
                //{
                //GameObject obj = objlist.get(i);
                GameObject obj = genobj;
                obj.getPos();
                //obj.drawSelf(canvasobj);//绘制obj到画布
                Paint p = new Paint();
                p.setColor(getResources().getColor(R.color.design_default_color_primary_dark));
                float xx,yy;
                adapter=new KNNAdapter(resp,aps);
                Address address = adapter.getAddress();
                xx= (float) address.getX();
                yy= (float) address.getY();
                Log.i("KNN","Located: "+xx+", "+yy);
                canvasobj.drawCircle(xx*300.0f, yy*300.0f, 20.0f, p);
                //i++;
                //}
                this.surfaceHolder.unlockCanvasAndPost(canvasobj);

            }try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    private void scanSuccess() {
        List<ScanResult> results = wifiManager.getScanResults();
        aps = new ArrayList<>();
        for (ScanResult r : results) {
            //resultv.append(r.BSSID + "," + r.SSID + "," + r.level + "\n");
            aps.add(new AP(r.BSSID,r.SSID,r.level));
        }
        //Toast.makeText(getActivity(), aps.size() + "APs detected.", Toast.LENGTH_SHORT).show();

    }

}