package com.example.orderfood.DTO;

public class Food_DTO {

    int id_food;
    String foodName;
    String foodCost;
    int id_KindOfFood;

    public Food_DTO() {
    }

    public Food_DTO(int id_food, String foodName, String foodCost, int id_KindOfFood) {
        this.id_food = id_food;
        this.foodName = foodName;
        this.foodCost = foodCost;
        this.id_KindOfFood = id_KindOfFood;
    }

    public int getId_food() {
        return id_food;
    }

    public void setId_food(int id_food) {
        this.id_food = id_food;
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
}
