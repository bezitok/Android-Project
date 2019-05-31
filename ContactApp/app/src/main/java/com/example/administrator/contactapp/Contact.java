package com.example.administrator.contactapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    int contactImage;
    String contactName;
    String contactNumber;

    protected Contact(Parcel in) {
        contactImage = in.readInt();
        contactName = in.readString();
        contactNumber = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public Contact() {

    }

    public Contact(int contactImage, String contactName, String contactNumber) {
        this.contactImage = contactImage;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public int getContactImage() {
        return contactImage;
    }

    public void setContactImage(int contactImage) {
        this.contactImage = contactImage;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(contactImage);
        dest.writeString(contactName);
        dest.writeString(contactNumber);
    }
}
