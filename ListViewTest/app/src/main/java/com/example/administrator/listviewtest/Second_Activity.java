package com.example.administrator.listviewtest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Second_Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String[] OS = {"Symbian", "Android", "iOS", "Blackberry"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, OS);
        arrayAdapter.notifyDataSetChanged();
        setListAdapter(arrayAdapter);

        
    }


}
