package com.example.staffsqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.staffsqlite.R;
import com.example.staffsqlite.Staff_DTO.Staff_DTO;

import java.util.List;

public class Custom_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Staff_DTO> list;

    public Custom_Adapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;


        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.one_staff, null);

            viewHolder = new ViewHolder();

            viewHolder.staff_Image = convertView.findViewById(R.id.staff_Image);
            viewHolder.staff_ID = convertView.findViewById(R.id.staff_ID);
            viewHolder.staff_Name = convertView.findViewById(R.id.staff_Name);
            viewHolder.staff_Age = convertView.findViewById(R.id.staff_Age);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Staff_DTO staff = list.get(position);
        viewHolder.staff_Name.setText(staff.getStaff_Name());
        viewHolder.staff_Age.setText(staff.getAge());

        return convertView;
    }

    public class ViewHolder{
        ImageView staff_Image;
        TextView staff_ID, staff_Name, staff_Age;
    }
}
