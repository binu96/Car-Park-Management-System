package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Binu Senevirathne on 11/14/2016.
 */
// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class DBconnection {

    Connection conn = null;


    public void connect() {

        try

        {

            Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection("jdbc:mysql://localhost/vehicle_parking_lot?" +
                    "user=root&password=");

//                    System.out.println("Connection Successful");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}