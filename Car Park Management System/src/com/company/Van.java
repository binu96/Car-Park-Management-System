package com.company;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public class Van extends Vehicle {

    protected double cargoVolume;

    public Van() {
    }

    public Van(double carVolume){

        this.cargoVolume = carVolume;
    }

    public Van(double carVolume, String id, String brandName, String entry){
        this.cargoVolume = carVolume;
        this.idPlate = id;
        this.brand = brandName;
        this.entryTime = entry;
    }
    public double getCargoVolume() {

        return cargoVolume;
    }

    public void setCarVolume(double carVolume) {

        this.cargoVolume = carVolume;
    }
}
