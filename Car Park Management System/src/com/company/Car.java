package com.company;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public class Car extends Vehicle {

    protected int numberOfDoors;
    protected String color;

    public Car() {
    }

    public Car(int doors, String color){
        this.numberOfDoors = doors;
        this.color = color;
    }

    public Car(int doors, String color, String id,String brandName,String entry){
        this.numberOfDoors = doors;
        this.color = color;
        this.idPlate = id;
        this.brand = brandName;
        this.entryTime = entry;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
