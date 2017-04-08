package com.company;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public class MotorBike extends Vehicle {

    protected double sizeOfEngine;

    public MotorBike() {

    }

    public MotorBike(double engineSize) {

        this.sizeOfEngine = engineSize;
    }

    public MotorBike(double engineSize, String id, String brandName, String entry) {
        this.sizeOfEngine = engineSize;
        this.idPlate = id;
        this.brand = brandName;
        this.entryTime = entry;
    }

    public double getSizeOfEngine() {

        return sizeOfEngine;
    }

    public void setSizeOfEngine(double sizeOfEngine) {

        this.sizeOfEngine = sizeOfEngine;
    }
}
