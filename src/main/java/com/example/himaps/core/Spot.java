package com.example.himaps.core;

import java.util.ArrayList;

public class Spot {
    public ArrayList<AP> ap;
    public int x;
    public int y;

    public Spot(ArrayList<AP> ap, int x, int y) {
        this.ap = ap;
        this.x = x;
        this.y = y;
    }
}
