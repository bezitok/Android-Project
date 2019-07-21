package com.example.orderfood.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfood.DAO.Account_DAO;
import com.example.orderfood.DTO.Account_DTO;
import com.example.orderfood.R;


public class Sign_In extends AppCompatActivity {

    EditText edt_name;
    EditText edt_password;
    EditText edt_confirmPassword;
    Button btn_signIn;
    TextView txt_Login;

    Account_DAO account_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        initWidget();

        account_dao = new Account_DAO(Sign_In.this);

    }

    public void ReturnLogin(View view) {
        Intent intent = new Intent(Sign_In.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void CreateAccount(View view) {

        String userName = edt_name.getText().toString();
        String password = edt_password.getText().toString();
        String confirmPassword = edt_confirmPassword.getText().toString();

        if(userName.isEmpty()){
            edt_name.setError("Null");
        }

    }

    public void initWidget(){
        edt_name = findViewById(R.id.edt_signIn_name);
        edt_password = findViewById(R.id.edt_signIn_password);
        edt_confirmPassword = findViewById(R.id.edt_confirm_Pasword);
        btn_signIn = findViewById(R.id.btn_signup);
        txt_Login = findViewById(R.id.txt_return_login);
    }

}
