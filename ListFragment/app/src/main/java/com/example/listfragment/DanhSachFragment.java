package com.example.listfragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DanhSachFragment extends ListFragment {

    String[] city = {"Hà Nội", "Nha Trang", "Móng Cái", "Bảo Lộc", "Việt Trì"};
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, city);

        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_danhsach, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), city[position], Toast.LENGTH_LONG).show();
    }
}
