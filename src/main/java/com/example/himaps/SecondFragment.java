package com.example.himaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {


    private MySurfaceView surfaceView;

    class GameObject {
        private int id;
        private String username;
        private int dis;
        private float x;
        private float y;
        private Bitmap img;
        private Paint paint;
        public GameObject(){
            this.img = BitmapFactory.decodeResource(getResources(),R.drawable.ic_md_location_on);
            this.x = -100;
            this.y = -100;
            this.paint=new Paint();
        }
        public void drawSelf(Canvas canvas){
            canvas.drawBitmap(img,x,y,paint);
        }
        public void getPos(){
            /**
             *
             * 获取坐标和用户信息
             * 加入objlist
             *
             * **/
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
        surfaceView = getActivity().findViewById(R.id.SurfaceView);
    }
}