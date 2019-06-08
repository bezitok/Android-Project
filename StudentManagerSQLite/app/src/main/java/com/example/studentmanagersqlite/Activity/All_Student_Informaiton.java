package com.example.studentmanagersqlite.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.studentmanagersqlite.Adapter.Custom_Adapter;
import com.example.studentmanagersqlite.R;
import com.example.studentmanagersqlite.Student_DAO.Student_DAO;
import com.example.studentmanagersqlite.Student_DTO.Student;

import java.util.ArrayList;

public class All_Student_Informaiton extends AppCompatActivity {

    ArrayList<Student> studentList;
    ListView listView;
    Student_DAO student_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_student_information);

        listView = findViewById(R.id.listView);

        studentList = (ArrayList<Student>) student_dao.getAllStudent();

        Custom_Adapter custom_adapter = new Custom_Adapter(All_Student_Informaiton.this, R.layout.one_student_information, studentList);
        custom_adapter.notifyDataSetChanged();
        listView.setAdapter(custom_adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                registerForContextMenu(listView);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int positionSelected = menuInfo.position;

        switch (item.getItemId()){
            case R.id.context_menu_detail:

                Student student = studentList.get(positionSelected);

                Intent intent1 = new Intent(All_Student_Informaiton.this, One_Student_Information.class);
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("student Selected",student);
                intent1.putExtras(bundle1);
                startActivity(intent1);

                break;
            case R.id.context_menu_edit:
                break;
            case R.id.context_menu_delete:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
