package com.example.changeorientationfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TruyenSinhVien{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void DataStudent(SinhVien sinhVien) {
        Fragment_Student_Infor fragment_student_infor = (Fragment_Student_Infor) getFragmentManager().findFragmentById(R.id.fragment_info);
        fragment_student_infor.setInfor(sinhVien);
    }
}
