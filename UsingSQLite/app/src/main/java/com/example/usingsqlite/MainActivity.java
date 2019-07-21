package com.example.usingsqlite;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usingsqlite.DAO.Company_DAO;
import com.example.usingsqlite.DTO.Company_DTO;

public class MainActivity extends AppCompatActivity {

    EditText edt_name, edt_address;
    Button btn_confirm, btn_cancel;
    Company_DAO company_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();

        company_dao = new Company_DAO(MainActivity.this);
    }

    public void AddCompany(View view) {
        String name = edt_name.getText().toString();
        String address = edt_address.getText().toString();
        if(name.isEmpty() || address.isEmpty()){
            Toast.makeText(MainActivity.this, "Không được để trống", Toast.LENGTH_LONG).show();
        }else{
            Company_DTO company = new Company_DTO();

            company.setCompany_Name(name);
            company.setCompany_Address(address);

            company_dao.addCompany(company);
            Toast.makeText(MainActivity.this, "Add successfully", Toast.LENGTH_LONG).show();
        }
    }

    public void Cancel(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Alert");
        builder.setMessage("Do you want to exit?");
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast.makeText(MainActivity.this, "Exit in " + millisUntilFinished/1000, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_LONG).show();
                    }
                }.start();
            }
        });
        builder.setPositiveButton("No", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void initWidget(){
        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_cancel = findViewById(R.id.btn_cancel);
    }
}
