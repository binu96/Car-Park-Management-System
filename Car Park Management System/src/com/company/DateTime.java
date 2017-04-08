
package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Binu Senevirathne on 11/12/2016.
 */
public class DateTime {

    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;

    public DateTime(){

    }
    public DateTime(int minute, int hour, int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.minute = minute;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day, int month, int year, int hour, int minute) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.minute = minute;
        this.hour = hour;
    }

    public String getDate() {
        String s = "";

        s += year;

        s += "/";

        if (month < 10) {
            s += ("0" + month);
        } else {
            s += month;
        }

        s += "/";

        if (day < 10) {
            s += ("0" + day);
        } else {
            s += day;
        }

        if(hour < 10){
            s += (" 0" + hour);
        } else {
            s += " " + hour;
        }

        if(minute < 10){
            s += (":0" + minute);
        } else {
            s += ":" + minute;
        }


        return s;
    }

    DateFormat date = new SimpleDateFormat("YYYY/MM/dd HH:mm");
    Date currentDate = new Date();

    public String gettingDate() {

        return date.format(currentDate);
    }

    public String toString() {
        String s = "";

        s += year;

        s += "/";

        if (month < 10) {
            s += ("0" + month);
        } else {
            s += month;
        }

        s += "/";

        if (day < 10) {
            s += ("0" + day);
        } else {
            s += day;
        }

        if(hour < 10){
            s += (" 0" + hour);
        } else {
            s += " " + hour;
        }

        if(minute < 10){
            s += (":0" + minute);
        } else {
            s += ":" + minute;
        }


        return s;
    }
}
