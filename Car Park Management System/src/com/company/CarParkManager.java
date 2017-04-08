package com.company;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public interface CarParkManager {

    public abstract void viewDetails(String givenDate);

    public abstract void listOfVehicles();

    public abstract void addVehicle(String[] vehicle);

    public abstract void deleteVehicle(String plateNo);

    public abstract void MainMenu();

    public static void main(String[] args) {

        CarParkManager sys = new WestminsterCarParkManager();

        sys.MainMenu();

    }
}
