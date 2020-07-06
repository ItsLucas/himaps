package com.github.AbouOpenSource;

import com.github.AbouOpenSource.Model.*;
import com.github.AbouOpenSource.core.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class AppMain {

    public static void main(String[] args) throws IOException {
        String path = "F:\\himaps\\KNN\\KNN-Indoor-Location-\\src\\main\\java\\com\\github\\AbouOpenSource\\data\\data.csv";

1
        Reader reader = new Reader(path);
        /**
         * for each address in the space, i associate a Cellule that contains the signal strength of each Ap in the env
         */
        HashMap<Address, Cellule> hashMap = reader.getCellules();
        Space space = new Space(hashMap);
        /**
         * with theses signals, with search cellules with more similar signal
         */
        Vector<AccessPoint> signaux = new Vector<AccessPoint>();
        signaux.add(new AccessPoint("AP1",-26));
        signaux.add(new AccessPoint("AP2",-42));
        signaux.add(new AccessPoint("AP3",-13));
        signaux.add(new AccessPoint("AP4",-46));
        Cellule cellule = new Cellule(signaux);

        //Address address =space.getNeighboors(cellule);
        //System.out.println(address);

        Vector<Cellule> vector = space.getKNeighboors(cellule,4);
        System.out.println("Les 4 voisins : ");
        for (Cellule celule:vector) {
            System.out.println(celule.getAddress());
        }
        /****************Without ponderation***************/
        Address address = space.getCenterWithoutPonderation(cellule,4);
        System.out.println("Center solution with:"+address);

        /*******************With ponderation***************************/
        System.out.println("With ponderation");
        Address address1 =space.getCenterWithPonderation(cellule,4);
       // System.out.println(address1);
    }


}
