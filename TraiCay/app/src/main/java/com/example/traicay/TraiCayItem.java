package com.example.traicay;

public class TraiCayItem {
    private int imgTraiCay;
    private String nameTraiCay;
    private String descriptionTraiCay;

    public TraiCayItem(int imgTraiCay, String nameTraiCay, String descriptionTraiCay) {
        this.imgTraiCay = imgTraiCay;
        this.nameTraiCay = nameTraiCay;
        this.descriptionTraiCay = descriptionTraiCay;
    }

    public int getImgTraiCay() {
        return imgTraiCay;
    }

    public void setImgTraiCay(int imgTraiCay) {
        this.imgTraiCay = imgTraiCay;
    }

    public String getNameTraiCay() {
        return nameTraiCay;
    }

    public void setNameTraiCay(String nameTraiCay) {
        this.nameTraiCay = nameTraiCay;
    }

    public String getDescriptionTraiCay() {
        return descriptionTraiCay;
    }

    public void setDescriptionTraiCay(String descriptionTraiCay) {
        this.descriptionTraiCay = descriptionTraiCay;
    }
}
