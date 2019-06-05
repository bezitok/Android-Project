package com.example.listviewwithcontextmenu;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    int studentImage;
    String name;
    String phone;
    String address;

    public Student() {
    }

    public Student(int studentImage, String name, String phone, String address) {
        this.studentImage = studentImage;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(int studentImage) {
        this.studentImage = studentImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    protected Student(Parcel in) {
        studentImage = in.readInt();
        name = in.readString();
        phone = in.readString();
        address = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(studentImage);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(address);
    }
}
