package com.example.changeorientationfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Student_Adapter extends BaseAdapter {

    Context context;
    int layout;
    List<SinhVien> list;

    public Student_Adapter(Context context, int layout, List<SinhVien> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();

            viewHolder.textView = convertView.findViewById(R.id.txt_name);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = list.get(position);

        viewHolder.textView.setText(sinhVien.getHoten());

        return convertView;
    }

    public class ViewHolder{
        TextView textView;
    }
}
