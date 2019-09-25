package com.example.orderfood.DTO;

public class Food_DTO {
    int id_Food;
    int id_KindOfFood;
    String foodName;
    String foodCost;
    String foodImage;

    public Food_DTO() {
    }

    public int getId_Food() {
        return id_Food;
    }

    public void setId_Food(int id_Food) {
        this.id_Food = id_Food;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
    }

    public int getId_KindOfFood() {
        return id_KindOfFood;
    }

    public void setId_KindOfFood(int id_KindOfFood) {
        this.id_KindOfFood = id_KindOfFood;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
