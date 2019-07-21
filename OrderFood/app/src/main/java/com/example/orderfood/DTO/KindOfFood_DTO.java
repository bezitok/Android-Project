package com.example.orderfood.DTO;

public class KindOfFood_DTO {
    int id_KindOfFood;
    String kindOfFood_Name;

    public KindOfFood_DTO() {
    }

    public KindOfFood_DTO(int id_KindOfFood, String kindOfFood_Name) {
        this.id_KindOfFood = id_KindOfFood;
        this.kindOfFood_Name = kindOfFood_Name;
    }

    public int getId_KindOfFood() {
        return id_KindOfFood;
    }

    public void setId_KindOfFood(int id_KindOfFood) {
        this.id_KindOfFood = id_KindOfFood;
    }

    public String getKindOfFood_Name() {
        return kindOfFood_Name;
    }

    public void setKindOfFood_Name(String kindOfFood_Name) {
        this.kindOfFood_Name = kindOfFood_Name;
    }
}
