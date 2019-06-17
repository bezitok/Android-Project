package com.example.studentmanagementsqlite.Student_DTO;

public class Student_DTO {
    int student_ID;
    String student_Name;
    String student_Code;
    String student_DOB;
    String student_Class;
    String student_Address;

    public Student_DTO() {
    }

    public Student_DTO(String student_Name, String student_Code, String student_DOB, String student_Class, String student_Address) {
        this.student_Name = student_Name;
        this.student_Code = student_Code;
        this.student_DOB = student_DOB;
        this.student_Class = student_Class;
        this.student_Address = student_Address;
    }

    public Student_DTO(int student_ID, String student_Name, String student_Code, String student_DOB, String student_Class, String student_Address) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.student_Code = student_Code;
        this.student_DOB = student_DOB;
        this.student_Class = student_Class;
        this.student_Address = student_Address;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_Code() {
        return student_Code;
    }

    public void setStudent_Code(String student_Code) {
        this.student_Code = student_Code;
    }

    public String getStudent_DOB() {
        return student_DOB;
    }

    public void setStudent_DOB(String student_DOB) {
        this.student_DOB = student_DOB;
    }

    public String getStudent_Class() {
        return student_Class;
    }

    public void setStudent_Class(String student_Class) {
        this.student_Class = student_Class;
    }

    public String getStudent_Address() {
        return student_Address;
    }

    public void setStudent_Address(String student_Address) {
        this.student_Address = student_Address;
    }
}
