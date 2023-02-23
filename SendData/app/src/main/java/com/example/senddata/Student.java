package com.example.senddata;

import java.io.Serializable;

public class Student implements Serializable {
    private String Name;
    private int Year;

    public Student(String name, int year) {
        Name = name;
        Year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
