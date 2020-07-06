package com.github.AbouOpenSource.core;

import com.github.AbouOpenSource.Model.AccessPoint;
import com.github.AbouOpenSource.Model.Address;
import com.github.AbouOpenSource.Model.Cellule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class Reader {
    String csvFile;
    String cvsSplitBy = ",";

    BufferedReader bufferedReader;
    public Reader(String csvFile) throws FileNotFoundException, IOException {
        this.csvFile = csvFile;

    }
    public Reader(String csvFile, String cvsSplitBy) throws FileNotFoundException, IOException {
        this.csvFile = csvFile;
        this.cvsSplitBy = cvsSplitBy;

    }



    public HashMap<Address, Cellule> getCellules() throws FileNotFoundException {
        String line = "";
        HashMap<Address, Cellule> hashMap = new HashMap<Address, Cellule>();


        bufferedReader = new BufferedReader(new FileReader(csvFile));
        try {
            while ((line = bufferedReader.readLine()) != null) {

                String[] elements = line.split(cvsSplitBy);
                Address address = new Address(elements[0],elements[1]);
                Vector<AccessPoint> vector = new Vector<AccessPoint>();
                vector.add(new AccessPoint("AP1",elements[2]));
                vector.add(new AccessPoint("AP2",elements[3]));
                vector.add(new AccessPoint("AP3",elements[4]));
                vector.add(new AccessPoint("AP4",elements[5]));
                Cellule cellule = new Cellule(address,vector);
                hashMap.put(cellule.getAddress(),cellule);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return hashMap;
    }





}
