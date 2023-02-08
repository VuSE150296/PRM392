package com.example.orderactivity;

public class FoodItems {
    private int FoodImg;
    private String FoodName;
    private String FoodDescription;

    public FoodItems(int foodImg, String foodName, String foodDescription) {
        FoodImg = foodImg;
        FoodName = foodName;
        FoodDescription = foodDescription;
    }

    public int getFoodImg() {
        return FoodImg;
    }

    public void setFoodImg(int foodImg) {
        FoodImg = foodImg;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodDescription() {
        return FoodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        FoodDescription = foodDescription;
    }
}
