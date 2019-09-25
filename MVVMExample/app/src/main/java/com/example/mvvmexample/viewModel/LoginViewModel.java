package com.example.mvvmexample.viewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.mvvmexample.Interface.LoginResultCallbacks;
import com.example.mvvmexample.model.User;

public class LoginViewModel extends ViewModel {

    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.user = new User();
        this.loginResultCallbacks = loginResultCallbacks;
    }

    //write method to get Email from EditText and set to user

    public TextWatcher getEmailTextWatcher () {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    //write method to get Password from EditText and set to user

    public TextWatcher getPasswordTextWatcher () {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPasword(s.toString());
            }
        };
    }

    //write method to process Login

    public void onLoginClicked(View view){
        if (user.isValidate()){
            loginResultCallbacks.onSuccess("Login success");
        }else {
            loginResultCallbacks.onError("Login error");
        }
    }
}
