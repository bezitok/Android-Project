package com.example.studentmanagementsqlite.Student_DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanagementsqlite.Database.Student_Database;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.ArrayList;
import java.util.List;

public class Student_DAO {

    Student_Database student_database;
    SQLiteDatabase sqLiteDatabase;
    String[] column_Student_Database = {Student_Database.student_ID, Student_Database.student_Name,
            Student_Database.student_Code, Student_Database.student_DOB, Student_Database.student_Class, Student_Database.student_Address};

    /**
     *
     * Khởi tạo database
     *
     * @param context
     */

    public Student_DAO(Context context){
        student_database = new Student_Database(context);
    }

    /**
     * Thêm 1 record vào database
     * @param student
     */

    public void addStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student_Database.student_Name, student.getStudent_Name());
        contentValues.put(Student_Database.student_Code, student.getStudent_Code());
        contentValues.put(Student_Database.student_DOB, student.getStudent_DOB());
        contentValues.put(Student_Database.student_Class, student.getStudent_Class());
        contentValues.put(Student_Database.student_Address, student.getStudent_Address());

        sqLiteDatabase.insert(Student_Database.TB_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public Student_DTO getStudentByID(int id){

        sqLiteDatabase = student_database.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Student_Database.TB_NAME, new String[]
                { Student_Database.student_ID, Student_Database.student_Name, Student_Database.student_Code, Student_Database.student_DOB, Student_Database.student_Class, Student_Database.student_Address},
                Student_Database.student_ID + " = ? ",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Student_DTO student = new Student_DTO(cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));

        cursor.close();
        sqLiteDatabase.close();
        return student;
    }

    /**
     * Hàm lấy ra toàn bộ danh sách sinh viên có trong database
     * Sử dụng cursor để duyệt từ đầu đến cuối danh sách
     * Mỗi khi duyệt đến một phần từ thì thêm phần tử đó vào 1 danh sách Student
     *
     * @return: kết quả trả ra là danh sách sinh viên sau khi đã duyệt đến phần tử cuối của database
     */

    public ArrayList<Student_DTO> getALLStudent(){

        ArrayList<Student_DTO> listStudent = new ArrayList<>();

        sqLiteDatabase = student_database.getWritableDatabase(); //Cấp quyền đọc/ghi database
        sqLiteDatabase = student_database.getReadableDatabase();

        String sqlite_Query = "Select * from " + Student_Database.TB_NAME; //Câu truy vấn SQLite

        Cursor cursor = sqLiteDatabase.rawQuery(sqlite_Query, null); //Thực thi câu truy vấn SQLite

//        Cursor cursor = sqLiteDatabase.query(Student_Database.TB_NAME, column_Student_Database, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){

            Student_DTO student = new Student_DTO();

            student.setStudent_ID(cursor.getInt(0));
            student.setStudent_Name(cursor.getString(1));
            student.setStudent_Code(cursor.getString(2));
            student.setStudent_DOB(cursor.getString(3));
            student.setStudent_Class(cursor.getString(4));
            student.setStudent_Address(cursor.getString(5));

            listStudent.add(student); //Thêm 1 phần tử vào trong list sau khi duyệt xong 1 phần từ
            cursor.moveToNext(); //di chuyển con trỏ sang phần tử tiếp theo trong database
        }

        return listStudent; //trả ra list Student sau khi duyệt
    }

    public void updateStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();
        sqLiteDatabase = student_database.getReadableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Student_Database.student_Name, student.getStudent_Name());
        contentValues.put(Student_Database.student_Code, student.getStudent_Code());
        contentValues.put(Student_Database.student_DOB, student.getStudent_DOB());
        contentValues.put(Student_Database.student_Class, student.getStudent_Class());
        contentValues.put(Student_Database.student_Address, student.getStudent_Address());

        sqLiteDatabase.update(Student_Database.TB_NAME, contentValues, Student_Database.student_ID
                + "=" + student.getStudent_ID(), null); //Xử lý cập nhật, chỉnh sửa thông tin sinh viên dựa vào id của sinh viên đó
    }

    public int deleteStudent(Student_DTO student){
        sqLiteDatabase = student_database.getWritableDatabase();
        return sqLiteDatabase.delete(Student_Database.TB_NAME, Student_Database.student_ID
                + "=?" , new String[] {String.valueOf(student.getStudent_ID())}); //Xóa 1 record khỏi database
    }

}
