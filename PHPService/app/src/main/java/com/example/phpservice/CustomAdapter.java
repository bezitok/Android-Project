package com.example.phpservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Student> studentList;

    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.studentList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.custom_one_student, null);

            viewHolder = new ViewHolder();

            viewHolder.tv_ID = convertView.findViewById(R.id.tv_id);
            viewHolder.tv_Name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_DOB = convertView.findViewById(R.id.tv_DOB);
            viewHolder.tv_Address = convertView.findViewById(R.id.tv_Address);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = studentList.get(position);
        viewHolder.tv_ID.setText(String.valueOf(student.getId()));
        viewHolder.tv_Name.setText(student.getHoTen());
        viewHolder.tv_DOB.setText(String.valueOf(student.getNamsSinh()));
        viewHolder.tv_Address.setText(student.getDiaChi());

        return convertView;
    }

    public class ViewHolder{
        TextView tv_ID;
        TextView tv_Name;
        TextView tv_DOB;
        TextView tv_Address;
    }
}
