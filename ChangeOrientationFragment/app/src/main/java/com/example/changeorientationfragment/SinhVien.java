package com.example.changeorientationfragment;

public class SinhVien {

    String hoten;
    int namSinh;
    String diaChi;
    String email;

    public SinhVien() {
    }

    public SinhVien(String hoten, int namSinh, String diaChi, String email) {
        this.hoten = hoten;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
