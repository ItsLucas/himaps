package com.example.himaps.core;

import com.example.himaps.Model.AccessPoint;
import com.example.himaps.Model.Address;
import com.example.himaps.Model.Cellule;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class JsonReader extends Reader {
    private Spots s;

    public JsonReader(String jsonstring) {
        s = new Gson().fromJson(jsonstring, Spots.class);
    }

    public Spots getSpots() {
        return s;
    }

    public HashMap<Address, Cellule> getCellulesByJson() {
        String line = "";
        HashMap<Address, Cellule> hashMap = new HashMap<Address, Cellule>();
        for (int i = 0; i < s.data.size(); i++) {
            Address address = new Address(s.data.get(i).x, s.data.get(i).y);
            Vector<AccessPoint> vector = new Vector<AccessPoint>();
            for (int j = 0; j < s.data.get(i).ap.size(); j++) {
                vector.add(new AccessPoint(s.data.get(i).ap.get(j).bssid, s.data.get(i).ap.get(j).strength));

            }
            Cellule cellule = new Cellule(address, vector);
            hashMap.put(cellule.getAddress(), cellule);
        }

        return hashMap;
    }
}
