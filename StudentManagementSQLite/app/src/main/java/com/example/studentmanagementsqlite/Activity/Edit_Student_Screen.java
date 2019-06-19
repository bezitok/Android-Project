package com.example.studentmanagementsqlite.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagementsqlite.R;

public class Edit_Student_Screen extends AppCompatActivity {

    EditText editText_Name, editText_Code, editText_DOB, editText_Class, editText_Address;
    Button button_Update, button_Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student_information);

        initWidget();

    }

    public void initWidget(){

        editText_Name = findViewById(R.id.edit_screen_editText_Name);
        editText_Code = findViewById(R.id.edit_screen_editText_Code);
        editText_DOB = findViewById(R.id.edit_screen_editText_DOB);
        editText_Class = findViewById(R.id.edit_screen_editText_Class);
        editText_Address = findViewById(R.id.edit_screen_editText_Address);

        button_Update = findViewById(R.id.edit_screen_Button_Update);
        button_Cancel = findViewById(R.id.edit_screen_Button_Cancel);
    }

    public void Update(View view){

    }

    public void Cancel(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(Edit_Student_Screen.this);

        builder.setCancelable(false);
        builder.setTitle("Confirm");
        builder.setMessage("Hủy cập nhật thông tin sinh viên?");
        builder.setPositiveButton("No", null);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Edit_Student_Screen.this, List_Student_Information.class);
                startActivity(intent);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
