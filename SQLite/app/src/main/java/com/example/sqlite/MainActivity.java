package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.Adapter.CustomAdapter;
import com.example.sqlite.DAO.NhanVien_DAO;
import com.example.sqlite.DTO.Staff;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    EditText editText;
    NhanVien_DAO nhanVien_dao;
    ListView listView;
    List<Staff> staffList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextUser);
        button1 = findViewById(R.id.buttonThem);
        listView = findViewById(R.id.listView);

        staffList = new ArrayList<>();
        adapter = new CustomAdapter(this, R.layout.custom_layout, staffList);
        listView.setAdapter(adapter);
        button1.setOnClickListener(this);

        nhanVien_dao = new NhanVien_DAO(this);
        nhanVien_dao.open();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonThem:

                Staff staff = new Staff();
                String tenNhanVien = editText.getText().toString();
                staff.setStaff_Name(tenNhanVien);
                staffList.add(staff);

                boolean check = nhanVien_dao.addStaff(staff);
                if(check){
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();

                }
                break;
            case R.id.buttonSua:
                break;
            case R.id.buttonXoa:
                break;
        }
    }
}
