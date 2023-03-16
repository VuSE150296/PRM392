package com.example.thethaoplus;

public class MyBooking {
    private String Date;
    private String Time;
    private String Status;
    private String Location;
    private String NameField;

    public MyBooking(String date, String time, String status, String location, String nameField) {
        Date = date;
        Time = time;
        Status = status;
        Location = location;
        NameField = nameField;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getNameField() {
        return NameField;
    }

    public void setNameField(String nameField) {
        NameField = nameField;
    }
}
