package com.example.orderactivity;

public class DrinkItems {
    private int DrinkImg;
    private String DrinkName;
    private String DrinkDescription;

    public DrinkItems(int drinkImg, String drinkName, String drinkDescription) {
        DrinkImg = drinkImg;
        DrinkName = drinkName;
        DrinkDescription = drinkDescription;
    }

    public int getDrinkImg() {
        return DrinkImg;
    }

    public void setDrinkImg(int drinkImg) {
        DrinkImg = drinkImg;
    }

    public String getDrinkName() {
        return DrinkName;
    }

    public void setDrinkName(String drinkName) {
        DrinkName = drinkName;
    }

    public String getDrinkDescription() {
        return DrinkDescription;
    }

    public void setDrinkDescription(String drinkDescription) {
        DrinkDescription = drinkDescription;
    }
}
