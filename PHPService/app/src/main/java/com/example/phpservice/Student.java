package com.example.phpservice;

public class Student {
    int id;
    String hoTen;
    int namsSinh;
    String diaChi;

    public Student() {
    }

    public Student(String hoTen, int namsSinh, String diaChi) {
        this.hoTen = hoTen;
        this.namsSinh = namsSinh;
        this.diaChi = diaChi;
    }

    public Student(int id, String hoTen, int namsSinh, String diaChi) {
        this.id = id;
        this.hoTen = hoTen;
        this.namsSinh = namsSinh;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamsSinh() {
        return namsSinh;
    }

    public void setNamsSinh(int namsSinh) {
        this.namsSinh = namsSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
