package com.example.listviewwithcontextmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class Information_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);
    }

    public class CustomAdapter extends ArrayAdapter {

        Context context;
        int resource;
        List<Student> list;

        public CustomAdapter(Context context, int resource, List objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.list = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            
            return super.getView(position, convertView, parent);
        }
    }
}
