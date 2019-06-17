package com.example.studentmanagementsqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.Student_DTO.Student_DTO;

import java.util.List;

public class Custom_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Student_DTO> list;

    public Custom_Adapter(Context context, int resource,List objects) {
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
            convertView = inflater.inflate(R.layout.one_student_listview, null);

            viewHolder = new ViewHolder();
            viewHolder.studentImage = convertView.findViewById(R.id.student_Image);
            viewHolder.studentName = convertView.findViewById(R.id.student_Name);
            viewHolder.studentCode = convertView.findViewById(R.id.student_Code);
            viewHolder.studentDOB = convertView.findViewById(R.id.student_DOB);
            viewHolder.studentClass = convertView.findViewById(R.id.student_Class);
            viewHolder.studentAddress = convertView.findViewById(R.id.student_Address);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student_DTO student = list.get(position);
        viewHolder.studentName.setText(student.getStudent_Name());
        viewHolder.studentCode.setText(student.getStudent_Code());
        viewHolder.studentDOB.setText(student.getStudent_DOB());
        viewHolder.studentClass.setText(student.getStudent_Class());
        viewHolder.studentAddress.setText(student.getStudent_Address());
        return convertView;
    }

    public class ViewHolder{
        ImageView studentImage;
        TextView studentName;
        TextView studentCode;
        TextView studentDOB;
        TextView studentClass;
        TextView studentAddress;
    }
}
