package com.github.AbouOpenSource.Model;

public class AccessPoint {
    /**
     * @ macAdrr allows us to keep in mind the identity of Ap, in order to avoid
     */
    String macAddr;
    /**
     * @ strength of the signal from this AP
     */

    double strength;

    public AccessPoint(String macAddr, double strength) {
        this.macAddr = macAddr;
        this.strength = strength;
    }

    public AccessPoint(String ap1, String element) {
        this.macAddr = ap1;
        this.strength = Integer.parseInt(element);

    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public boolean isSame(String macAddr){
        return this.macAddr.equals(macAddr);
    }
}
