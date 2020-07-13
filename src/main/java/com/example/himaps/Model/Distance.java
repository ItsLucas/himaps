package com.example.himaps.Model;

public class Distance implements Comparable {

    double distance;
    Cellule cellule;
    double coefficient;

    public Distance(double distance, Cellule cellule) {
        this.distance = distance;
        this.cellule = cellule;
    }

    public double getDistance() {
        return distance;
    }

    public Cellule getCellule() {
        return cellule;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setCellule(Cellule cellule) {
        this.cellule = cellule;
    }

    public int compareTo(Object o) {

        if (this.getDistance() == ((Distance) o).getDistance())
            return 0;

        if (this.getDistance() < ((Distance) o).getDistance()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }
}
