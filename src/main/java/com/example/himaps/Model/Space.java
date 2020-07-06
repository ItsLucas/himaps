package com.github.AbouOpenSource.Model;

import java.util.*;

public class Space {

    HashMap<Address, Cellule> mapCellule;

    public Space() {
    }

    public Space(HashMap<Address, Cellule> mapCellule) {
        this.mapCellule= mapCellule;
    }

    public void addWithAdr(Cellule cellule){
        mapCellule.put(cellule.getAddress(), cellule);
     }

    public Cellule getCelluleWithAddr(Address address,int signal){
        return mapCellule.get(address);
    }

    /**
     * @paragraphe The Euclidean distance
     * @param cellule
     * @param cellule1
     * @return
     */
    public double computeDistance(Cellule cellule, Cellule cellule1){
        return Math.sqrt(
          Math.pow(cellule.getAccessPoints().elementAt(0).strength-cellule1.getAccessPoints().elementAt(0).strength,2)+
          Math.pow(cellule.getAccessPoints().elementAt(1).strength-cellule1.getAccessPoints().elementAt(1).strength,2)+
          Math.pow(cellule.getAccessPoints().elementAt(2).strength-cellule1.getAccessPoints().elementAt(2).strength,2)+
          Math.pow(cellule.getAccessPoints().elementAt(3).strength-cellule1.getAccessPoints().elementAt(3).strength,2)
        );
    }

    public Vector<Cellule> getKNeighboors(Cellule cellule, int k){
        Vector<Distance> KNeighboors = new Vector<Distance>();
       Cellule tmp = new Cellule();

           for (Map.Entry<Address, Cellule> entry : mapCellule.entrySet()) {
                double distance_compute = this.computeDistance(entry.getValue(),cellule);
                KNeighboors.add(new Distance(distance_compute, entry.getValue()));

           }
        double somme =0;

           for (int index = 0; index <k; index ++){
               somme+= KNeighboors.elementAt(index ).distance;
           }
        for (int index = 0; index <k; index ++){
            KNeighboors.elementAt(index ).coefficient=KNeighboors.elementAt(index).distance/somme;
        }
           Collections.sort(KNeighboors);
        Vector<Cellule > cellules= new Vector<Cellule>();
        cellules.add(KNeighboors.get(0).getCellule());
        cellules.add(KNeighboors.get(1).getCellule());
        cellules.add(KNeighboors.get(2).getCellule());
        cellules.add(KNeighboors.get(3).getCellule());



        return cellules;
    }

    public Address getNeighboors(Cellule cellule){
        double distance =99999;
        Cellule tmp = new Cellule();
        for (int i=0; i<mapCellule.size(); i++){
            for (Map.Entry<Address, Cellule> entry : mapCellule.entrySet()) {
                double dis=this.computeDistance(entry.getValue(),cellule);
                if(distance>dis ){
                    distance=dis;
                    tmp= entry.getValue();
                }

            }
        }
        return tmp.getAddress();
    }

    public Address getCenterWithoutPonderation(Cellule cellule, int k){
       Address address = new Address(0,0);
        Vector<Cellule> vector =  getKNeighboors( cellule,  k);
        for(int index = 0; index< vector.size(); index++ ){
             address.add(vector.elementAt(index).getAddress()) ;

        }

        return address.div(vector.size());
    }

    public  Vector<Distance> getApWithPonderation(Cellule cellule, int k){

        Vector<Distance> KNeighboors = new Vector<Distance>();
        Cellule tmp = new Cellule();

        for (Map.Entry<Address, Cellule> entry : mapCellule.entrySet()) {
            double distance_compute = this.computeDistance(entry.getValue(),cellule);
            KNeighboors.add(new Distance(distance_compute, entry.getValue()));

        }
        Collections.sort(KNeighboors);
        double somme =0;
        for (int index = 0; index <k; index ++){
            somme+= KNeighboors.elementAt(index ).distance;
        }
        for (int index = 0; index <k; index ++){
            KNeighboors.elementAt(index ).coefficient=somme/KNeighboors.elementAt(index).distance;
        }

        for (int w =0 ; w<k;w++){
            System.out.println(KNeighboors.elementAt(w).cellule.getAddress()+" With coeff :" +KNeighboors.elementAt(w).coefficient);
        }

        return KNeighboors;


    }


    public  Address getCenterWithPonderation(Cellule cellule, int k){
        Address address = new Address(0,0);
        Vector<Distance> KNeighboors = new Vector<Distance>();
        Cellule tmp = new Cellule();

        for (Map.Entry<Address, Cellule> entry : mapCellule.entrySet()) {
            double distance_compute = this.computeDistance(entry.getValue(),cellule);
            KNeighboors.add(new Distance(distance_compute, entry.getValue()));

        }
        Collections.sort(KNeighboors);
        double somme =0;
        for (int index = 0; index <k; index ++){
            somme+= KNeighboors.elementAt(index ).distance;
        }
        for (int index = 0; index <k; index ++){
            KNeighboors.elementAt(index ).coefficient=somme/KNeighboors.elementAt(index).distance;
        }

        for (int w =0 ; w<k ; w++){
            System.out.println(KNeighboors.elementAt(w).cellule.getAddress()+" With coeff :" +KNeighboors.elementAt(w).coefficient);
            address.add(KNeighboors.elementAt(w).cellule.getAddress().mul( KNeighboors.elementAt(w).coefficient));
        }


        return address.div(k*somme);


    }

}
