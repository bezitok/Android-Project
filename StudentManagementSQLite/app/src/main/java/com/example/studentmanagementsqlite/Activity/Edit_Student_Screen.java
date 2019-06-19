package com.example.studentmanagementsqlite.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DAO.Student_DAO;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.Calendar;

public class Edit_Student_Screen extends AppCompatActivity {

    EditText editText_Name, editText_Code, editText_DOB, editText_Class, editText_Address;
    Button button_Update, button_Cancel;
    Student_DTO student;
    DatePickerDialog datePickerDialog;

    public static final String RESULT = "result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student_information);

        initWidget();

        Intent intent = getIntent();

        student = intent.getParcelableExtra(List_Student_Information.key_To_Put); //Nhận dữ liệu từ activity List_Student để chỉnh sửa

        loadData(); //Hàm xử lý dữ liệu nhận được

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

    /**
     * Chỉnh sửa thông tin sinh viên nhận được từ activity List_Student
     *
     * @param view
     */

    public void Update(View view){

        String student_Name = editText_Name.getText().toString();
        String student_Code = editText_Code.getText().toString();
        String student_DOB = editText_DOB.getText().toString();
        String student_Class = editText_Class.getText().toString();
        String student_Address = editText_Address.getText().toString();



        if(student_Name.isEmpty() || student_Code.isEmpty() || student_DOB.isEmpty() ||              //Kiểm tra xem các trường có bị bỏ trống hay không
                student_Class.isEmpty() || student_Address.isEmpty()){

            AlertDialog.Builder builder = new AlertDialog.Builder(Edit_Student_Screen.this);
            builder.setCancelable(false);
            builder.setTitle("Warning");
            builder.setMessage("Các trường không được để trống");
            builder.setNegativeButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }else{
            Intent intent = new Intent();

            Student_DTO student = new Student_DTO();

            student.setStudent_ID(this.student.getStudent_ID());
            student.setStudent_Name(student_Name);
            student.setStudent_Code(student_Code);
            student.setStudent_DOB(student_DOB);
            student.setStudent_Class(student_Class);
            student.setStudent_Address(student_Address);

            Toast.makeText(Edit_Student_Screen.this, "Cập nhật thông tin sinh viên thành công", Toast.LENGTH_LONG).show();

            intent.putExtra(RESULT, student);  //Gửi ngược lại dữ liệu đã được chỉnh sửa về activity List_Student

            setResult(RESULT_OK, intent);

            finish();
        }

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

    public void loadData(){

        editText_Name.setText(student.getStudent_Name());
        editText_Code.setText(student.getStudent_Code());
        editText_DOB.setText(student.getStudent_DOB());
        editText_Class.setText(student.getStudent_Class());
        editText_Address.setText(student.getStudent_Address());
    }

    public void Get_Student_DOB(View view) {

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(Edit_Student_Screen.this, android.app.AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editText_DOB.setText( dayOfMonth + "/" + (month+1) + "/" + year);
            }
        }, year, month, day);

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }
}
