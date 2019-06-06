package com.example.listviewwithcontextmenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Edit_Student_Information extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button1, button2;
    Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student_information);

        editText1 = findViewById(R.id.editText_Edited_Student_Name);
        editText2 = findViewById(R.id.editText_Edited_Student_Phone);
        editText3 = findViewById(R.id.editText_Edited_Student_Address);

        button1 = findViewById(R.id.button_Update);
        button2 = findViewById(R.id.button_Cancel);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        student = bundle.getParcelable("Student");


    }

    public void Update(View view) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Student student = bundle.getParcelable("Student");


    }

    public void Cancel(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Edit_Student_Information.this);
        builder.setTitle("Alert");
        builder.setMessage("Xác nhận hủy cập nhật thông tin?");
        builder.setCancelable(false);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent1 = new Intent(Edit_Student_Information.this, Information_Screen.class);
                startActivity(intent1);

            }
        });
        builder.setPositiveButton("No", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
