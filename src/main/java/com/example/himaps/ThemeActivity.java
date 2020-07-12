package com.example.himaps;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ThemeActivity extends AppCompatActivity {

    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sprfMain = getSharedPreferences("counter", Context.MODE_PRIVATE);
        editorMain = sprfMain.edit();
        //取出保存的值（取数据）
        boolean isChecked = sprfMain.getBoolean("isChecked", false);
        //根据保存的值设置主题状态
        if (isChecked) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}