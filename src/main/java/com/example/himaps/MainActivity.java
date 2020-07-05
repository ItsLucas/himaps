package com.example.himaps;

import android.graphics.ImageDecoder;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup menuGroup;
    private FragmentManager fragmentManager;

    private static final String[] FRAGMENT_TAG = {"tab_main","tab_map", "tab_user"};
    private final int show_tab_main = 0;//菜单
    private final int show_tab_map = 1;//地图
    private final int show_tab_user = 2;//用户
    private int mrIndex = show_tab_main;//默认选中

    private int index = -100;// 记录当前的选项

    private FirstFragment mainFragment;
    private SecondFragment mapFragment;
    private ThirdFragment userFragment;
    private static final String PRV_SELINDEX = "PREV_SELINDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            mrIndex = savedInstanceState.getInt(PRV_SELINDEX, mrIndex);

            mainFragment = (FirstFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            mapFragment = (SecondFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            userFragment = (ThirdFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);
        }
        int id = getIntent().getIntExtra("id", 0);
        if (id == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.FirstFragment,new FirstFragment())
                    .addToBackStack(null)
                    .commit();
        }
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(PRV_SELINDEX, mrIndex);
        super.onSaveInstanceState(outState);
    }
    protected void initView() {
        //获得RadioGroup控件
        menuGroup = (RadioGroup)findViewById(R.id.menu_group);
        //选择设置Fragment
        setTabSelection(show_tab_main);
        //点击事件
        menuGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.menu_main://主菜单
                        setTabSelection(show_tab_main);
                        break;
                    case R.id.menu_map://地图
                        setTabSelection(show_tab_map);
                        break;
                    case R.id.menu_user://发现
                        setTabSelection(show_tab_user);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    private void setTabSelection(int id) {    //根据传入的index参数来设置选中的tab页。
        if (id == index) {
            return;
        }
        index = id;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case show_tab_main:
                menuGroup.check(R.id.menu_main);
                if (mainFragment == null) {
                    mainFragment = new FirstFragment();
                    transaction.add(R.id.fl_container, mainFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(mainFragment);
                }
                transaction.commit();
                break;
            case show_tab_map://地图的fragment
                menuGroup.check(R.id.menu_map);
                if (mapFragment == null) {
                    mapFragment = new SecondFragment();
                    transaction.add(R.id.fl_container, mapFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(mapFragment);
                }
                transaction.commit();
                break;
            case show_tab_user://的fragment
                menuGroup.check(R.id.menu_user);//设置商城被选中
                if (userFragment == null) {
                    userFragment = new ThirdFragment();
                    transaction.add(R.id.fl_container, userFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(userFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (mapFragment != null) {
            transaction.hide(mapFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }
}