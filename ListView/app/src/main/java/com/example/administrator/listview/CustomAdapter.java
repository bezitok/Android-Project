package com.example.administrator.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private int resID;
    private List<Student> studentList;
    public CustomAdapter(Context context, int resID, List<Student> studentList) {
        super(context, resID, studentList);
        this.context = context;
        this.resID = resID;
        this.studentList = studentList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder = new ViewHolder();
        if(itemView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.second_activity, null);

            return itemView;
        }
    }

    private class ViewHolder {
        ;
    }
}
