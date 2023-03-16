package com.example.thethaoplusadmin;

public class FieldAddress {
    private String Name;
    private String Address;
    private String Star;
    private String Available;

    public FieldAddress(String name, String address, String star, String available) {
        Name = name;
        Address = address;
        Star = star;
        Available = available;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStar() {
        return Star;
    }

    public void setStar(String star) {
        Star = star;
    }

    public String getAvailable() {
        return Available;
    }

    public void setAvailable(String available) {
        Available = available;
    }
}
