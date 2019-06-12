package com.example.studentmanagersqlite.Student_DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    int student_ID;
    String student_Name;
    String student_Code;
    String student_DOB;
    String student_Class;
    String student_Address;

    public Student() {
    }

    public Student(String student_Name, String student_Code, String student_DOB, String student_Class, String student_Address) {
        this.student_Name = student_Name;
        this.student_Code = student_Code;
        this.student_DOB = student_DOB;
        this.student_Class = student_Class;
        this.student_Address = student_Address;
    }

    public Student(int student_ID, String student_Name, String student_Code, String student_DOB, String student_Class, String student_Address) {
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

    protected Student(Parcel in) {
        student_ID = in.readInt();
        student_Name = in.readString();
        student_Code = in.readString();
        student_DOB = in.readString();
        student_Class = in.readString();
        student_Address = in.readString();
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
        dest.writeInt(student_ID);
        dest.writeString(student_Name);
        dest.writeString(student_Code);
        dest.writeString(student_DOB);
        dest.writeString(student_Class);
        dest.writeString(student_Address);
    }
}
