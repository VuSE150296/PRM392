package com.example.se150296_pe2023.models;

public class Nhanvien {
    private long id;
    private String name;
    private String date;
    private String gender;
    private String salary;

    public Nhanvien(long id, String name, String date, String gender, String salary) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.salary = salary;
    }

    public Nhanvien(String name, String date, String gender, String salary) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
