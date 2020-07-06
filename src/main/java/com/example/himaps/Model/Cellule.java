package com.github.AbouOpenSource.Model;

import java.util.Vector;

public class Cellule {
    Address address;
    Vector<AccessPoint> accessPoints;

    public Cellule() {
    }

    public Cellule(Address address, Vector<AccessPoint> accessPoints) {
        this.address = address;
        this.accessPoints = accessPoints;
    }

    public Cellule(Vector<AccessPoint> accessPoints) {
        this.accessPoints = accessPoints;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Vector<AccessPoint> getAccessPoints() {
        return accessPoints;
    }

    public double[] getVectorOfSignal(){

        double[] multiples = new double[accessPoints.size()];
        for (int i =0 ; i< accessPoints.size();i++) {
            multiples[i] = accessPoints.elementAt(i).getStrength();
        }
        return  multiples;
    }

}
