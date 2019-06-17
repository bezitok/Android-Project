package com.example.staffsqlite;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.staffsqlite.Adapter.Custom_Adapter;
import com.example.staffsqlite.Staff_DAO.Staff_DAO;
import com.example.staffsqlite.Staff_DTO.Staff_DTO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Staff_DAO staff_dao;
    Staff_DTO staff;
    EditText editText1, editText2;
    Button button1, button2;
    ArrayList<Staff_DTO> staffList;
    ListView listView;
    Custom_Adapter custom_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText_Name);
        editText2 = findViewById(R.id.editText_Age);

        button1 = findViewById(R.id.btn_Submit);
        button2 = findViewById(R.id.btn_Cancel);
        listView = findViewById(R.id.listView);

        staffList = new ArrayList<>();
        custom_adapter = new Custom_Adapter(this, R.layout.one_staff, staffList);

        listView.setAdapter(custom_adapter);

        staff_dao = new Staff_DAO(this);

    }

    public void Submit(View view) {
        staff = new Staff_DTO();

        staff.setImage(R.drawable.baseline_account_circle_black_36);
        staff.setStaff_Name(editText1.getText().toString());
        staff.setAge(editText2.getText().toString());

        staffList.add(staff);

        staff_dao.addStaff(staff);
        custom_adapter.notifyDataSetChanged();
    }

    public void Cancel(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setMessage("Xác nhận thoát?");
        builder.setCancelable(false);

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(3000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Toast.makeText(MainActivity.this, "Chương trình sẽ thoát trong " + millisUntilFinished/1000 + " giây ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Chương trình đã thoát", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }.start();
            }
        });

        builder.setPositiveButton("No" , null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
