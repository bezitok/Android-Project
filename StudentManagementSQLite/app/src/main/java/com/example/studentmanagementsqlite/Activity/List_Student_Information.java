package com.example.studentmanagementsqlite.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    public static final String studentDetail = "student";
    public static final String key_To_Put = "studentSelected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_student_information);

        listView = findViewById(R.id.listView);

        student_dao = new Student_DAO(List_Student_Information.this); //khởi tạo Database

        studentList = student_dao.getALLStudent(); //lấy toàn bộ danh sách sinh viên từ database đổ vào listView

        setAdapter();

        registerForContextMenu(listView); //khởi tạo contextMenu

        /**
         *Nhấn vào từng item trong contextMenu thì chuyển qua màn hình chi tiết sinh viên
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(List_Student_Information.this, One_Student_Info.class);
                Bundle bundle = new Bundle();
                Student_DTO student = studentList.get(position);
                bundle.putParcelable(studentDetail, student);
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
                bundle.putParcelable(studentDetail, student); //gửi dữ liệu sang activity Student_Detail
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.context_menu_edit:

                Student_DTO studentSelected = studentList.get(pos); //Lấy vị trí của item đang được nhấn

                Intent intent1 = new Intent(List_Student_Information.this, Edit_Student_Screen.class);
                intent1.putExtra(key_To_Put, studentSelected); //gửi dữ liệu sang activity Edit_Student
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
                        int kq = student_dao.deleteStudent(student1); //Xóa 1 record khỏi database
                        if (kq > 0) {
                            Toast.makeText(List_Student_Information.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                            updateListStudent(); //Cập nhật lại listView
                        } else {
                            Toast.makeText(List_Student_Information.this, "Xóa không thành công", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

        }

        return super.onContextItemSelected(item);
    }

    /**
     * Hàm nhận dữ liệu trả về từ activity chỉnh sửa thông tin sinh viên
     *
     * @param requestCode: Code yêu cầu khi gửi dữ liệu từ activity List_Student_Information sang activity Edit_Student
     * @param resultCode: code kết quả nhận về từ activity Edit_Student
     * @param data: dữ liệu nhận về từ activity Edit_Student
     *
     */


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            Student_DTO student = data.getParcelableExtra(Edit_Student_Screen.RESULT); //nhận dữ liệu sinh viên đã chỉnh sửa được trả về từ activity Edit_Student

            student_dao.updateStudent(student); //Cập nhật lại database đã chỉnh sửa

            updateListStudent(); //Cập nhật lại listView
        }
    }

    /**
     * Hàm cập nhật danh sách sinh viên mỗi khi có sự thay đổi về dữ liệu trong database
     */

    public void updateListStudent() {
        studentList.clear();
        studentList.addAll(student_dao.getALLStudent());
        if (custom_adapter != null) {
            custom_adapter.notifyDataSetChanged();
        }
        if (studentList.isEmpty()) {
            Intent intent = new Intent(List_Student_Information.this, Empty_List_Student.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * Hàm set adapter để đổ dữ liệu lên listView
     */

    public void setAdapter() {
        if (custom_adapter == null) {
            custom_adapter = new Custom_Adapter(List_Student_Information.this, R.layout.one_student_listview, studentList);
            listView.setAdapter(custom_adapter);
        } else {
            custom_adapter.notifyDataSetChanged();
        }
    }

}
