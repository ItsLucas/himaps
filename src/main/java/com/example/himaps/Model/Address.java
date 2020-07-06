package com.github.AbouOpenSource.Model;

public class Address {
    double x;
    double y;

    public Address(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Address() {
        this.x =0;
        this.y = 0;
    }

    public Address(String element, String element1) {
        this.x=Integer.parseInt(element);
        this.y= Integer.parseInt(element1);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return x == address.x &&
                y == address.y;
    }

    @Override
    public String toString() {
        return "Address{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Address add(Address address){
        this.setX(this.getX()+address.getX());
        this.setY(this.getY()+address.getY());
        return this;
    }

    public Address div(double div){
       this.setY(this.getY()/div);
       this.setX(this.getX()/div);

        return this;
    }
    public Address mul(double div){
        this.setY(this.getY()*div);
        this.setX(this.getX()*div);

        return this;
    }
}
