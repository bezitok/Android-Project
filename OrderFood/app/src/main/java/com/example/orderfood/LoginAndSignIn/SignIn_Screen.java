package com.example.orderfood.LoginAndSignIn;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfood.R;

import java.util.Calendar;


public class SignIn_Screen extends AppCompatActivity {

    EditText editText_UserName, editText_UserPassword, editText_Staff_DateOfBirth, editText_Staff_IdentityCard;
    RadioGroup radioGroup_Staff_Sex;
    RadioButton radioButton_Staff_Sex_Male, RadioButton_Staff_Sex_Female;
    Button buttonRegister;
    TextView textViewCancel;
    int count = 0;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen);

        editText_UserName = findViewById(R.id.editText_UserName);
        editText_UserPassword = findViewById(R.id.editText_UserPassword);
        editText_Staff_DateOfBirth = findViewById(R.id.editText_Staff_DateOfBirth);
        editText_Staff_IdentityCard = findViewById(R.id.editText_Staff_Identity_Card);
        radioGroup_Staff_Sex = findViewById(R.id.radioGroup_StaffSex);
        radioButton_Staff_Sex_Male = findViewById(R.id.rb_Staff_Sex_Male);
        RadioButton_Staff_Sex_Female = findViewById(R.id.rb_Staff_Sex_Female);
        buttonRegister = findViewById(R.id.buttonRegister);
        textViewCancel = findViewById(R.id.textViewCancel);
    }

    public void Cancel(final View view) {

        for(int i=1; i<=3; i++){

        }
        finish();
    }

    public void Staff_Date_Of_Birth(View view) {
        editText_Staff_DateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int staff_Date_Of_Birth = calendar.get(Calendar.DAY_OF_MONTH);
                int staff_Month_Of_Birth = calendar.get(Calendar.MONTH);
                int staff_Year_Of_Birth = calendar.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(SignIn_Screen.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        editText_Staff_DateOfBirth.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, staff_Year_Of_Birth, staff_Month_Of_Birth, staff_Date_Of_Birth);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }
}
