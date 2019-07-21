package com.example.orderfood.DTO;

public class Account_DTO {
    int id_account;
    String user_name;
    String password;

    public Account_DTO() {
    }

    public Account_DTO(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public Account_DTO(int id_account, String user_name, String password) {
        this.id_account = id_account;
        this.user_name = user_name;
        this.password = password;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
