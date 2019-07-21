package com.example.changeorientationfragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_SinhVien extends ListFragment {

    ArrayList<SinhVien> arrayList;
    Student_Adapter student_adapter;

    TruyenSinhVien truyenSinhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        truyenSinhVien = (TruyenSinhVien) getActivity();

        arrayList = new ArrayList<>();

        AddSinhvien();

        student_adapter = new Student_Adapter(getActivity(), R.layout.one_student, arrayList);
        setListAdapter(student_adapter);

        return inflater.inflate(R.layout.fragment_sinhvien, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        truyenSinhVien.DataStudent(arrayList.get(position));
    }

    private void AddSinhvien(){
        arrayList.add(new SinhVien("Nguyễn Ngọc Hải", 1999, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc A", 1998, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc B", 1997, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc C", 1996, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc D", 1995, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc E", 1994, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc F", 1993, "Nam Định", "nguyenhaikiller@gmail.com"));
        arrayList.add(new SinhVien("Nguyễn Ngọc G", 1992, "Nam Định", "nguyenhaikiller@gmail.com"));
    }
}
