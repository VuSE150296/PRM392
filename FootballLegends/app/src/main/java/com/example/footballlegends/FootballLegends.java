package com.example.footballlegends;

public class FootballLegends {
    private int Avatar;
    private String Name;
    private String Description;
    private int Country;

    public FootballLegends(int avatar, String name, String description, int country) {
        Avatar = avatar;
        Name = name;
        Description = description;
        Country = country;
    }

    public int getAvatar() {
        return Avatar;
    }

    public void setAvatar(int avatar) {
        Avatar = avatar;
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

    public int getCountry() {
        return Country;
    }

    public void setCountry(int country) {
        Country = country;
    }
}
