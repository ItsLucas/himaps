package com.example.himaps.core;

public class AP {
    public String bssid;
    public String ssid;
    public int strength;

    public AP(String bssid, String ssid, int strength) {
        this.bssid = bssid;
        this.ssid = ssid;
        this.strength = strength;
    }
}
