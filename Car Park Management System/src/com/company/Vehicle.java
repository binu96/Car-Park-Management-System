package com.company;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public abstract class Vehicle {

    protected String idPlate;
    protected String brand;
    protected String entryTime;

    public Vehicle() {

    }

    public Vehicle(String id, String brandName, String entry) {
        this.idPlate = id;
        this.brand = brandName;
        this.entryTime = entry;
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }
}
