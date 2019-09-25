package com.example.mvvmexample.model;

import android.databinding.BaseObservable;
import android.text.TextUtils;
import android.util.Patterns;

public class User extends BaseObservable {

    private String email, pasword;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public boolean isValidate() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPasword().length() > 6;
    }
}
