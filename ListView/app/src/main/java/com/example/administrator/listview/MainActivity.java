package com.example.administrator.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> arrItem = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Tao");
        arrItem.add("Mày");
        arrItem.add("Thằng nào");
        arrItem.add("Bố Hải");
        arrItem.add("Đẹp chai");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,  arrItem);
        listView.setAdapter(arrayAdapter);

    }




}
