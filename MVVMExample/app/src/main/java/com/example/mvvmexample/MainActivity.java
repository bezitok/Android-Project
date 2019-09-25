package com.example.mvvmexample;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.mvvmexample.Interface.LoginResultCallbacks;
import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.viewModel.LoginViewModel;
import com.example.mvvmexample.viewModel.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
    }
}
