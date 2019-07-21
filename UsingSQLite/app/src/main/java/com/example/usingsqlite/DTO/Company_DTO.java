package com.example.usingsqlite.DTO;

public class Company_DTO {
    int ID;
    String company_Name;
    String company_Address;

    public Company_DTO() {
    }

    public Company_DTO(String company_Name, String company_Address) {
        this.company_Name = company_Name;
        this.company_Address = company_Address;
    }

    public Company_DTO(int ID, String company_Name, String company_Address) {
        this.ID = ID;
        this.company_Name = company_Name;
        this.company_Address = company_Address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCompany_Name() {
        return company_Name;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public String getCompany_Address() {
        return company_Address;
    }

    public void setCompany_Address(String company_Address) {
        this.company_Address = company_Address;
    }
}
