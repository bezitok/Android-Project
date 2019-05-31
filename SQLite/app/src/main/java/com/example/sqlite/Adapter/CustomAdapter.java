package com.example.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sqlite.DTO.Staff;
import com.example.sqlite.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Staff> {

    Context context;
    int resource;
    List<Staff> staff;

    public CustomAdapter(Context context, int resource, List<Staff> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.staff = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(staff.get(position).getStaff_Name());
        return view;
    }
}
