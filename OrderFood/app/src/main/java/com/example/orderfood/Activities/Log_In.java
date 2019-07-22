package com.example.orderfood.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.orderfood.DAO.Account_DAO;
import com.example.orderfood.Database.Create_Database;
import com.example.orderfood.R;

public class Log_In extends AppCompatActivity {

    RelativeLayout parent, rellay1;
    EditText edt_UserName;
    EditText edt_Password;
    Button btn_Login;

    Account_DAO account_dao = new Account_DAO(Log_In.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        parent = findViewById(R.id.parent);
        rellay1 = findViewById(R.id.rellay1);
        initWidget();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rellay1.setVisibility(View.VISIBLE);
            }
        }, 2000);

    }

    public void Login(View view) {

        final String userName = edt_UserName.getText().toString();
        final String password = edt_Password.getText().toString();

        if(userName.isEmpty() || password.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Log_In.this);
            builder.setCancelable(false);
            builder.setTitle("Alert");
            builder.setMessage("Fields can't be empty. Please try again");
            builder.setPositiveButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else{

            boolean check = account_dao.processLogin(userName, password);

            if(check){
                Toast.makeText(Log_In.this, "Log In Successfully", Toast.LENGTH_LONG).show();
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Log_In.this);
                builder.setCancelable(false);
                builder.setTitle("Alert");
                builder.setMessage("Username or password is incorrect. Please try again.");
                builder.setPositiveButton("OK", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        }
    }

    public void Create(View view) {
        Intent intent = new Intent(Log_In.this, Sign_In.class);
        startActivity(intent);
        finish();
    }

    public void initWidget(){
        edt_UserName = findViewById(R.id.edt_userName);
        edt_Password = findViewById(R.id.edt_userPassword);
        btn_Login = findViewById(R.id.btn_Login);
    }
}
