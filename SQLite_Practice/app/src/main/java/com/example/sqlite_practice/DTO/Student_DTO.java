package com.example.sqlite_practice.DTO;

public class Student_DTO {
    int ID;
    String Name;
    String Classroom;

    public Student_DTO() {
    }

    public Student_DTO(int ID, String name, String classroom) {
        this.ID = ID;
        Name = name;
        Classroom = classroom;
    }

    public Student_DTO(String name, String classroom) {
        Name = name;
        Classroom = classroom;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }
}
