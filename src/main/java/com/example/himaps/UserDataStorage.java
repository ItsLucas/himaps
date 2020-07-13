package com.example.himaps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;

import com.example.himaps.Model.UserData;
import com.example.himaps.core.AP;

import java.util.ArrayList;

public class UserDataStorage {
    public static UserData data = new UserData();
    public static ArrayList<AP> aps;
    public static WifiManager wifiManager;
    public static BroadcastReceiver br;
    public static boolean stopThread = false;
    public static String resp;
    public static float curx = 0;
    public static float cury = 0;
    public static boolean vanish = false;
    public static UserLocData ldata;
    public static boolean covidwatcher = false;
}
