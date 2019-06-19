package com.example.studentmanagementsqlite.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studentmanagementsqlite.Adapter.Custom_Adapter;
import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DAO.Student_DAO;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.ArrayList;

public class List_Student_Information extends AppCompatActivity {

    ListView listView;

    ArrayList<Student_DTO> studentList;
    Student_DAO student_dao;
    Custom_Adapter custom_adapter;
    Student_DTO student1;

    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_student_information);

        listView = findViewById(R.id.listView);

        student_dao = new Student_DAO(List_Student_Information.this);

        studentList = student_dao.getALLStudent();

        setAdapter();

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(List_Student_Information.this, One_Student_Info.class);
                Bundle bundle = new Bundle();
                Student_DTO student = studentList.get(position);
                bundle.putParcelable("student", student);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int pos = menuInfo.position;

        switch (item.getItemId()) {
            case R.id.context_menu_detail:

                menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                Intent intent = new Intent(List_Student_Information.this, One_Student_Info.class);
                Bundle bundle = new Bundle();
                Student_DTO student = studentList.get(menuInfo.position);
                bundle.putParcelable("student", student);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.context_menu_edit:

                Student_DTO studentSelected = studentList.get(pos);

                Intent intent1 = new Intent(List_Student_Information.this, Edit_Student_Screen.class);
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("studentEdit", studentSelected);
                intent1.putExtras(bundle1);
                startActivityForResult(intent1, REQUEST_CODE);

                break;
            case R.id.context_menu_delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(List_Student_Information.this);

                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Xác nhận xóa sinh viên?");
                builder.setPositiveButton("No", null);
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        student1 = studentList.get(pos);
                        int kq = student_dao.deleteStudent(student1);
                        if(kq>0){
                            Toast.makeText(List_Student_Information.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                            updateListStudent();
                        }else{
                            Toast.makeText(List_Student_Information.this, "Xóa không thành công", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void updateListStudent(){
        studentList.clear();
        studentList.addAll(student_dao.getALLStudent());
        if(custom_adapter!=null){
            custom_adapter.notifyDataSetChanged();
        }
        if(studentList.isEmpty()){
            Intent intent = new Intent(List_Student_Information.this, Empty_List_Student.class);
            startActivity(intent);
        }
    }

    public void setAdapter(){
        if(custom_adapter == null){
            custom_adapter = new Custom_Adapter(List_Student_Information.this, R.layout.one_student_listview, studentList);
            listView.setAdapter(custom_adapter);
        }else{
            custom_adapter.notifyDataSetChanged();
        }
    }
}
