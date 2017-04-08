package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public class WestminsterCarParkManager implements CarParkManager {


    String parkingLots[] = new String[19];

    String vehicle[] = new String[5];

    private int choice;

    private String id;
    private String brand;
    private String dateTime;
    private String color;
    private String door;
    private String volume;
    private String engSize;
    private int slot;
    private String vehicleType;
    private String date;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    public void MainMenu() {

        int choice1 = 0;
        String plate = "";
        String brand = "";
        String entryDate = "";
        Scanner sc = new Scanner(System.in);

        choice1 = 9;

        while (choice1 != 0) {

            try {

                System.out.println("WESTMINSTER CAR PARK SYSTEM");
                System.out.println("_______________________________________________________________________________________________________");
                System.out.println("Press (1) to add a vehicle");
                System.out.println("Press (2) to delete ");
                System.out.println("Press (3) to view ");
                System.out.println("Press (4) to get the records");
                System.out.println("Press (0) to exit");

                System.out.println("-------------------------------------------------------------------------------------------------------");
                choice1 = sc.nextInt();
                System.out.println("_______________________________________________________________________________________________________");

                switch (choice1) {

                    case 1:
                        int slots = freeSlots();
                        System.out.println("Available number of free slots are : " + slots);
                        System.out.println("-------------------------------------------------------------------------------------------------------");

                        if (slots <= 0) {
                            System.err.println("No space for parking.");
                            System.out.println("-------------------------------------------------------------------------------------------------------");

                        } else {

                            System.out.println("press (1) to add a car");
                            System.out.println("press (2) to add a van");
                            System.out.println("press (3) to add a motorbike");
                            System.out.println("-------------------------------------------------------------------------------------------------------");
                            choice = sc.nextInt();
                            System.out.println("_______________________________________________________________________________________________________");

                            switch (choice) {

                                case 1:
                                    System.out.println("Please enter the id plate :");
                                    System.out.println("Eg: yu123");
                                    plate = sc.next();

                                    System.out.println("Please enter the brand of the vehicle :");
                                    System.out.println("Eg: ford");

                                    brand = sc.next();

                                    do {
                                        System.out.println("Enter day : ");
                                        System.out.println("Eg: 11 (days do not exceed 30 or 31)");
                                        day = sc.nextInt();
                                    } while (day < 1 || day > 31);

                                    do {
                                        System.out.println("Enter month : ");
                                        System.out.println("Eg: 9 (months do not exceed 12)");
                                        month = sc.nextInt();
                                    } while (month < 1 || month > 12);

                                    do {
                                        System.out.println("Enter year : ");
                                        System.out.println("Eg: 2016 (year have only 4 digits)");
                                        year = sc.nextInt();
                                    } while (year < 1940 || year > 2100);

                                    do {
                                        System.out.println("Enter hour : ");
                                        System.out.println("Eg: 21 (a day have only 24 hours");
                                        hour = sc.nextInt();
                                    } while (hour < 0 || hour > 24);

                                    do {
                                        System.out.println("Enter minutes : ");
                                        System.out.println("Eg: 24 (a hour have only 59 minutes including 0");
                                        minute = sc.nextInt();
                                    } while (minute < 0 || minute > 59);

                                    DateTime date = new DateTime(minute, hour, day, month, year);
                                    entryDate = date.getDate();

                                    System.out.println("Please enter the color :");
                                    System.out.println("Eg: red");
                                    String color = sc.next();

                                    System.out.println("Please enter the number of doors of the car :");
                                    System.out.println("Eg: 2");
                                    int doors = sc.nextInt();

                                    Car c = new Car(doors, color, plate, brand, entryDate);
                                    vehicle[0] = plate;
                                    vehicle[1] = brand;
                                    vehicle[2] = entryDate;
                                    vehicle[3] = color;
                                    vehicle[4] = String.valueOf(doors);


                                    addVehicle(vehicle);
                                    System.out.println("-------------------------------------------------------------------------------------------------------");
                                    System.out.println("Data provided was Successfully Stored.");
                                    System.out.println("-------------------------------------------------------------------------------------------------------");

                                    break;
                                case 2:

                                    if (slots == 1) {
                                        System.err.println("No space for parking for a van");

                                    } else {
                                        System.out.println("Please enter the id plate :");
                                        System.out.println("Eg: yu123");
                                        plate = sc.next();

                                        System.out.println("Please enter the brand of the vehicle :");
                                        System.out.println("Eg: ford");
                                        brand = sc.next();

                                        do {
                                            System.out.println("Enter day : ");
                                            System.out.println("Eg: 11 (days do not exceed 30 or 31)");
                                            day = sc.nextInt();
                                        } while (day < 1 || day > 31);

                                        do {
                                            System.out.println("Enter month : ");
                                            System.out.println("Eg: 9 (months do not exceed 12)");
                                            month = sc.nextInt();
                                        } while (month < 1 || month > 12);

                                        do {
                                            System.out.println("Enter year : ");
                                            System.out.println("Eg: 2016 (year have only 4 digits)");
                                            year = sc.nextInt();
                                        } while (year < 1940 || year > 2100);

                                        do {
                                            System.out.println("Enter hour : ");
                                            System.out.println("Eg: 21 (a day have only 24 hours");
                                            hour = sc.nextInt();
                                        } while (hour < 0 || hour > 24);

                                        do {
                                            System.out.println("Enter minutes : ");
                                            System.out.println("Eg: 24 (a hour have only 59 minutes including 0");
                                            minute = sc.nextInt();
                                        } while (minute < 0 || minute > 59);

                                        DateTime date1 = new DateTime(minute, hour, day, month, year);
                                        entryDate = date1.getDate();

                                        System.out.println("Please enter the volume of the cargo :");
                                        System.out.println("Eg: 750");
                                        double volume = sc.nextDouble();

                                        Van v = new Van(volume, plate, brand, entryDate);
                                        vehicle[0] = plate;
                                        vehicle[1] = brand;
                                        vehicle[2] = entryDate;
                                        vehicle[3] = String.valueOf(volume);


                                        addVehicle(vehicle);
                                        System.out.println("-------------------------------------------------------------------------------------------------------");
                                        System.out.println("Data provided was Successfully Stored.");
                                        System.out.println("-------------------------------------------------------------------------------------------------------");

                                    }
                                    break;

                                case 3:
                                    System.out.println("Please enter the id plate :");
                                    System.out.println("Eg: yu123");
                                    plate = sc.next();

                                    System.out.println("Please enter the brand of the vehicle :");
                                    System.out.println("Eg: honda");
                                    brand = sc.next();

                                    do {
                                        System.out.println("Enter day : ");
                                        System.out.println("Eg: 11 (days do not exceed 30 or 31)");
                                        day = sc.nextInt();
                                    } while (day < 1 || day > 31);

                                    do {
                                        System.out.println("Enter month : ");
                                        System.out.println("Eg: 9 (months do not exceed 12)");
                                        month = sc.nextInt();
                                    } while (month < 1 || month > 12);

                                    do {
                                        System.out.println("Enter year : ");
                                        System.out.println("Eg: 2016 (year have only 4 digits)");
                                        year = sc.nextInt();
                                    } while (year < 1940 || year > 2100);

                                    do {
                                        System.out.println("Enter hour : ");
                                        System.out.println("Eg: 21 (a day have only 24 hours");
                                        hour = sc.nextInt();
                                    } while (hour < 0 || hour > 24);

                                    do {
                                        System.out.println("Enter minutes : ");
                                        System.out.println("Eg: 24 (a hour have only 59 minutes including 0");
                                        minute = sc.nextInt();
                                    } while (minute < 0 || minute > 59);

                                    DateTime date2 = new DateTime(minute, hour, day, month, year);
                                    entryDate = date2.getDate();


                                    System.out.println("Please enter the size of the engine :");
                                    System.out.println("Eg: 1200");
                                    double engSize = sc.nextDouble();

                                    MotorBike m = new MotorBike(engSize, plate, brand, entryDate);
                                    vehicle[0] = plate;
                                    vehicle[1] = brand;
                                    vehicle[2] = entryDate;
                                    vehicle[3] = String.valueOf(engSize);

                                    addVehicle(vehicle);
                                    System.out.println("-------------------------------------------------------------------------------------------------------");
                                    System.out.println("Data provided was Successfully Stored.");
                                    System.out.println("-------------------------------------------------------------------------------------------------------");
                                    break;
                            }

                        }
                        break;

                    case 2:
                        System.out.println("Please Enter the licence plate number : ");
                        plate = sc.next();
                        deleteVehicle(plate);
                        System.out.println("Data provided was Successfully Deleted.");
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                        break;

                    case 3:
                        listOfVehicles();
                        break;

                    case 4:
                        System.out.println("Please enter the date in following format.");
                        System.out.println("Eg : YYYY/MM/DD ");
                        date = sc.next();
                        viewDetails(date);
                        break;

                    case 0:
                        System.exit(0);
                        break;

                }

            } catch (InputMismatchException e) {
                System.err.println("Enter a valid input");
                sc.next();
                System.out.println();
            }

        }

    }


    @Override
    public void viewDetails(String givenDate) {

        ArrayList plateNumbers = new ArrayList<String>();
        DBconnection db = new DBconnection();
        db.connect();

        Statement stmt = null;

        try {
            stmt = db.conn.createStatement();

            String queryDetail = "SELECT Plate, EntryTime FROM parking_space";

            ResultSet resultDetail = stmt.executeQuery(queryDetail);
            while (resultDetail.next()) {

                dateTime = resultDetail.getString("EntryTime");
                String dt = dateTime.substring(0, 10);


                if (dt.equals(givenDate)) {
                    id = resultDetail.getString("Plate");

                    plateNumbers.add(id);

                }
            }
            if (plateNumbers.isEmpty()) {

                System.out.println("There are no parking on " + givenDate + ".");
                System.out.println("_______________________________________________________________________________________________________");

            } else {

                for (int i = 0; i < plateNumbers.size(); i++) {//looping and reading the array list
                    id = (String) plateNumbers.get(i);

                    String queryDateDetails = "SELECT * FROM parking_space WHERE Plate = '" + id + "'";

                    ResultSet resultDateDetail = stmt.executeQuery(queryDateDetails);
                    while (resultDateDetail.next()) {
                        System.out.println("_______________________________________________________________________________________________________");
                        System.out.println("Plate No : " + resultDateDetail.getString("Plate") +
                                " : Entry time of " + resultDateDetail.getString("VehicleType") +
                                " is at : " + resultDateDetail.getString("EntryTime"));
                        System.out.println("_______________________________________________________________________________________________________");
                        System.out.println();
                    }
                }

            }


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {

        }
    }

    @Override
    public void listOfVehicles() {

        DBconnection db = new DBconnection();
        db.connect();

        Statement stmt = null;
        String queryCount = "";
        String queryCar = "";
        String queryVan = "";
        String queryMotorBike = "";
        int countTotal = 0;
        double price = 0.0;

        //to add the dates of the database
        ArrayList date = new ArrayList<String>();

        //to add the id of the database
        ArrayList id = new ArrayList<String>();


        try {

            stmt = db.conn.createStatement();

            queryCount = "SELECT COUNT(Plate) AS countTotal FROM parking_space";

            ResultSet result = stmt.executeQuery(queryCount);

            System.out.println("Percentages of occupied vehicles :");
            System.out.println("_______________________________________________________________________________________________________");
            while (result.next()) {

                countTotal = (result.getInt("countTotal"));
            }


            queryCar = "SELECT COUNT(VehicleType) AS countCar FROM parking_space WHERE VehicleType = 'car'";
            ResultSet resultCar = stmt.executeQuery(queryCar);

            while (resultCar.next()) {

                int countCar = (resultCar.getInt("countCar"));
                System.out.println("The percentage of cars in the parking lot is        : " + ((countCar * 100) / countTotal) + "%");
            }


            queryVan = "SELECT COUNT(VehicleType) AS countVan FROM parking_space WHERE VehicleType = 'van'";
            ResultSet resultVan = stmt.executeQuery(queryVan);

            while (resultVan.next()) {

                int countVan = (resultVan.getInt("countVan"));
                System.out.println("The percentage of vans in the parking lot is        : " + ((countVan * 100) / countTotal) + "%");
            }


            queryMotorBike = "SELECT COUNT(VehicleType) AS countMotorBike FROM parking_space WHERE VehicleType = 'motor_bike'";
            ResultSet resultMotorBike = stmt.executeQuery(queryMotorBike);

            while (resultMotorBike.next()) {

                int countMotorBike = (resultMotorBike.getInt("countMotorBike"));
                System.out.println("The percentage of Motor Bikes in the parking lot is : " + ((countMotorBike * 100) / countTotal) + "%");
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println();

            for (int i = countTotal; i > 0; i--) {

                int n = i - 1;

                String queryPrint = "SELECT * FROM parking_space LIMIT 1 OFFSET " + n;

                ResultSet result1 = stmt.executeQuery(queryPrint);

                while (result1.next()) {

                    date.add(result1.getString("EntryTime"));
                    id.add(result1.getString("Plate"));


                }
            }

            //create a multidimentional array
            String[][] data = new String[countTotal][2];

            //loop the date and id arrays and put those data into the multidimentional array
            for (int i = 0; i < countTotal; i++) {

                data[i][0] = (String) date.get(i);
                data[i][1] = (String) id.get(i);

            }


            Arrays.sort(data, new Comparator<String[]>() { //to compare the strings
                @Override
                public int compare(final String[] entry1, final String[] entry2) {
                    final String time1 = entry1[0];
                    final String time2 = entry2[0];
                    return time2.compareTo(time1);
                }
            });

            String queryLongest = "SELECT * FROM parking_space WHERE Plate = '" + data[countTotal - 1][1] + "'";

            ResultSet resultLongest = stmt.executeQuery(queryLongest);

            while (resultLongest.next()) {

                System.out.println("The details of the vehicle which has parked for the longest time period.");
                System.out.println("_______________________________________________________________________________________________________");
                System.out.println("Plate No : " + resultLongest.getString("Plate") +
                        " : Entry time of " + resultLongest.getString("VehicleType") +
                        " is at : " + resultLongest.getString("EntryTime"));

            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println();
            int countTot = countTotal - 1;
            String queryLast = "SELECT * FROM parking_space WHERE Plate = '" + data[0][1] + "'";

            ResultSet resultLast = stmt.executeQuery(queryLast);

            while (resultLast.next()) {

                System.out.println("The details of the vehicle which parked last.");
                System.out.println("_______________________________________________________________________________________________________");
                System.out.println("Plate No : " + resultLast.getString("Plate") +
                        " : Entry time of " + resultLast.getString("VehicleType") +
                        " is at : " + resultLast.getString("EntryTime"));

            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println();

            System.out.println("List of vehicles currently parked");
            System.out.println("_______________________________________________________________________________________________________");


            for (int i = 0; i < countTotal; i++) {
                String queryList = "SELECT * FROM parking_space WHERE Plate = '" + data[i][1] + "'";

                ResultSet resultList = stmt.executeQuery(queryList);

                if (resultList.next()) {

                    dateTime = resultList.getString("EntryTime");

                    price = CalculatePrice(dateTime);

                    System.out.println("Plate No : " + resultList.getString("Plate") +
                            " : Entry time of " + resultList.getString("VehicleType") +
                            " is at : " + resultList.getString("EntryTime") + " " +
                            ": Parking Charge Currently : " + "\u20ac" + round(price, 2));

                }
            }

            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {

        }

    }

    @Override
    public void addVehicle(String[] vehicle) {

        id = vehicle[0];
        brand = vehicle[1];
        dateTime = vehicle[2];
        color = "";
        door = "";
        volume = "";
        engSize = "";
        slot = 0;
        vehicleType = "";


        switch (choice) {

            case 1:
                color = vehicle[3];
                door = vehicle[4];
                vehicleType = "car";
                slot = 1;
                break;
            case 2:
                volume = vehicle[3];
                vehicleType = "van";
                slot = 2;
                break;
            case 3:
                engSize = vehicle[3];
                vehicleType = "motor_bike";
                slot = 1;
                break;

        }
        DBconnection db = new DBconnection();
        db.connect();
        Statement stmt = null;
        ResultSet rs = null;

        try {

            stmt = db.conn.createStatement();

            String queryAdd = "INSERT INTO parking_space(Plate, Brand, EntryTime, Color, NumberOfDoors, CargoVolume, " +
                    "EngineSize, Slots, VehicleType)" + "VALUES('" + id + "','" + brand + "','" + dateTime + "','"
                    + color + "','" + door + "','" + volume + "','" + engSize + "','" + slot + "','" + vehicleType + "')";

            stmt.executeUpdate(queryAdd);


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


    @Override
    public void deleteVehicle(String plateNo) {
        DBconnection db = new DBconnection();
        db.connect();
        Statement stmt = null;
        ResultSet rs = null;
        String queryDelete = "";
        try {
            stmt = db.conn.createStatement();
            String querySelect = "SELECT * FROM parking_space WHERE Plate = '" + plateNo + "'";

            ResultSet result = stmt.executeQuery(querySelect);

            if (result.next()) {


                id = result.getString("Plate");
                vehicleType = result.getString("VehicleType");
                dateTime = result.getString("EntryTime");


                double price = CalculatePrice(dateTime);

                queryDelete = "DELETE FROM parking_space WHERE Plate = '" + id + "'";
                stmt.executeUpdate(queryDelete);

                System.out.println("_______________________________________________________________________________________________________");
                System.out.println("The " + vehicleType + " - plate no : " + id + " is leaving.");
                System.out.println("The Parking Charge is : " + "\u20ac" + round(price, 2));
                System.out.println("_______________________________________________________________________________________________________");


            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("There is an Exception");
        }


    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public double CalculatePrice(String dateTime) {

        double price = 0.00;
        Date d1 = null;
        Date d2 = null;

        try {
            DateTime time = new DateTime();

            String currentTime = time.gettingDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

            d1 = sdf.parse(dateTime);

            d2 = sdf.parse(currentTime);

            long timeSpent = d2.getTime() - d1.getTime();

            double diffMinutes = timeSpent / (60 * 1000) % 60;
            long diffHours = timeSpent / (60 * 60 * 1000) % 24;
            long diffDays = timeSpent / (24 * 60 * 60 * 1000);

            double hourCount = (diffDays * 24) + diffHours + (diffMinutes / 60);

            if (hourCount > 3.0 && diffDays == 0) {
                price = 3 * 3 + (hourCount - 3);

            } else if (diffDays >= 1) {
                price = (diffDays * 30) + diffHours + (diffMinutes / 60);

            } else {
                price = hourCount * 3;
            }


        } catch (Exception e) {

            System.err.println("Wrong time");
        }
        return price;

    }

    public int freeSlots() {

        DBconnection db = new DBconnection();
        db.connect();
        int slotAdd = 0;
        Statement stmt = null;
        int freeSpace = 0;

        try {
            stmt = db.conn.createStatement();

            String querySlots = "SELECT Slots FROM parking_space";

            ResultSet resultSlot = stmt.executeQuery(querySlots);
            while (resultSlot.next()) {
                slotAdd = slotAdd + Integer.parseInt(resultSlot.getString("Slots"));
            }
            freeSpace = 20 - slotAdd;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {

        }
        return freeSpace;
    }
}

