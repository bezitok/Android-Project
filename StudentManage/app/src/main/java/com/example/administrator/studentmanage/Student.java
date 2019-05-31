package com.example.administrator.studentmanage;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    int studentImage;
    String studentName;
    int studentAge;
    String studentAddress;

    public Student() {
    }

    public Student(int studentImage, String studentName, int studentAge, String studentAddress) {
        this.studentImage = studentImage;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentAddress = studentAddress;
    }

    protected Student(Parcel in) {
        studentImage = in.readInt();
        studentName = in.readString();
        studentAge = in.readInt();
        studentAddress = in.readString();
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

    public int getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(int studentImage) {
        this.studentImage = studentImage;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(studentImage);
        dest.writeString(studentName);
        dest.writeInt(studentAge);
        dest.writeString(studentAddress);
    }
}
