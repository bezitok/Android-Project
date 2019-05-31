package com.example.orderfood.LoginAndSignIn.DTO;

public class Staff_DTO {
    int staff_ID;
    String staff_UserName, staff_Password, staff_Sex, staff_Date_Of_Birth, staff_Identity_Card;

    public Staff_DTO() {
    }

    public Staff_DTO(int staff_ID, String staff_UserName, String staff_Password, String staff_Sex, String staff_Date_Of_Birth, String staff_Identity_Card) {
        this.staff_ID = staff_ID;
        this.staff_UserName = staff_UserName;
        this.staff_Password = staff_Password;
        this.staff_Sex = staff_Sex;
        this.staff_Date_Of_Birth = staff_Date_Of_Birth;
        this.staff_Identity_Card = staff_Identity_Card;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getStaff_UserName() {
        return staff_UserName;
    }

    public void setStaff_UserName(String staff_UserName) {
        this.staff_UserName = staff_UserName;
    }

    public String getStaff_Password() {
        return staff_Password;
    }

    public void setStaff_Password(String staff_Password) {
        this.staff_Password = staff_Password;
    }

    public String getStaff_Sex() {
        return staff_Sex;
    }

    public void setStaff_Sex(String staff_Sex) {
        this.staff_Sex = staff_Sex;
    }

    public String getStaff_Date_Of_Birth() {
        return staff_Date_Of_Birth;
    }

    public void setStaff_Date_Of_Birth(String staff_Date_Of_Birth) {
        this.staff_Date_Of_Birth = staff_Date_Of_Birth;
    }

    public String getStaff_Identity_Card() {
        return staff_Identity_Card;
    }

    public void setStaff_Identity_Card(String staff_Identity_Card) {
        this.staff_Identity_Card = staff_Identity_Card;
    }
}
