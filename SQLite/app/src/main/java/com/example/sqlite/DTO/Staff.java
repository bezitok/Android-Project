package com.example.sqlite.DTO;

public class Staff {
    int _id;
    String staff_Name;

    public Staff() {
    }

    public Staff(int _id, String staff_Name) {
        this._id = _id;
        this.staff_Name = staff_Name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        this.staff_Name = staff_Name;
    }
}
