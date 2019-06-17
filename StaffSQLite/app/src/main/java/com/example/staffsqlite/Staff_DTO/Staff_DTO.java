package com.example.staffsqlite.Staff_DTO;

public class Staff_DTO {

    int ID;
    int image;
    String staff_Name;
    String age;

    public Staff_DTO() {
    }

    public Staff_DTO(int image, String staff_Name, String age) {
        this.image = image;
        this.staff_Name = staff_Name;
        this.age = age;
    }

    public Staff_DTO(int ID, int image, String staff_Name, String age) {
        this.ID = ID;
        this.image = image;
        this.staff_Name = staff_Name;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        this.staff_Name = staff_Name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
