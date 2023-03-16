package com.example.pe.models;

public class Person {
    private long id;
    private String Name;
    private String Phone;

    public Person(long id, String name, String phone) {
        this.id = id;
        Name = name;
        Phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person(String name, String phone) {
        Name = name;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
