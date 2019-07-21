package com.example.changeorientationfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_Student_Infor extends Fragment {

    TextView txtHoTen, txtNamSinh, txtDiaChi, txtEmail;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_student_infor, container, false);

        init();

        return view;
    }

    public void setInfor(SinhVien sinhVien){
        txtHoTen.setText(sinhVien.getHoten());
        txtNamSinh.setText("Năm sinh: " + sinhVien.getNamSinh());
        txtDiaChi.setText("Địa chỉ: "+ sinhVien.getDiaChi());
        txtEmail.setText("Email: " + sinhVien.getEmail());
    }

    private void init(){
        txtHoTen = view.findViewById(R.id.txt_hoten);
        txtNamSinh = view.findViewById(R.id.txt_namsinh);
        txtDiaChi = view.findViewById(R.id.txt_diachi);
        txtEmail = view.findViewById(R.id.txt_email);
    }
}
