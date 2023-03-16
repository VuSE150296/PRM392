package com.example.se150296_pe2023.models;

public class Phongban {
    private long id;
    private String namePB;

    public Phongban(long id, String namePB) {
        this.id = id;
        this.namePB = namePB;
    }

    public Phongban(String namePB) {
        this.namePB = namePB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePB() {
        return namePB;
    }

    public void setNamePB(String namePB) {
        this.namePB = namePB;
    }
}
