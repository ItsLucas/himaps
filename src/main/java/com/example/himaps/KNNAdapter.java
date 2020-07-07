package com.example.himaps;

import com.example.himaps.Model.AccessPoint;
import com.example.himaps.Model.Address;
import com.example.himaps.Model.Cellule;
import com.example.himaps.Model.Space;
import com.example.himaps.core.AP;
import com.example.himaps.core.JsonReader;
import com.example.himaps.core.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class KNNAdapter {
    private Space space;
    private Vector<AccessPoint> signaux;
    private Cellule cellule;

    public Address getAddress() {
        return address;
    }

    private Address address;
    public KNNAdapter(String jsonstring, ArrayList<AP> aps) {
        JsonReader reader = new JsonReader(jsonstring);
        HashMap<Address, Cellule> hashMap = reader.getCellulesByJson();
        space = new Space(hashMap);
        signaux = new Vector<AccessPoint>();
        for(int i=0;i<aps.size();i++) {
            signaux.add(new AccessPoint(aps.get(i).bssid,aps.get(i).strength));
        }
        cellule = new Cellule(signaux);
        //Vector<Cellule> vector = space.getKNeighboors(cellule,4);
        //System.out.println("K=4: ");
        address = space.getCenterWithoutPonderation(cellule,6);
    }
}
