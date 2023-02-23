package com.example.recyclerview.Models;

public class Product {
    private Integer Image;
    private String Name;
    private String Description;
    private String Software;

    public Product(Integer image, String name, String description, String software) {
        Image = image;
        Name = name;
        Description = description;
        Software = software;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSoftware() {
        return Software;
    }

    public void setSoftware(String software) {
        Software = software;
    }
}
