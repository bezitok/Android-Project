package com.example.orderfood.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
        setContentView(R.layout.sign_in);

        initWidget();

        account_dao = new Account_DAO(Sign_In.this);

    }

    public void ReturnLogin(View view) {
        Intent intent = new Intent(Sign_In.this, Log_In.class);
        startActivity(intent);
        finish();
    }

    public void CreateAccount(View view) {

        String userName = edt_name.getText().toString();
        String password = edt_password.getText().toString();
        String confirmPassword = edt_confirmPassword.getText().toString();

        if(userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_In.this);
            builder.setCancelable(false);
            builder.setTitle("Alert");
            builder.setMessage("Fields can't be empty. Please try again");
            builder.setPositiveButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else{
            if(password.compareTo(confirmPassword) != 0){
                edt_confirmPassword.setError("Password is incorrect");
            }else{
                Account_DTO account = new Account_DTO();

                account.setUser_name(userName);
                account.setPassword(password);
                account_dao.createNewAccount(account);

                Toast.makeText(Sign_In.this, "Create account successfully", Toast.LENGTH_LONG).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Sign_In.this, Log_In.class);
                        startActivity(intent);
                        finish();
                    }
                },500);
            }
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
