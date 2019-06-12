package com.example.studentmanagersqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentmanagersqlite.R;
import com.example.studentmanagersqlite.Student_DTO.Student;

import java.util.List;

public class Custom_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Student> list;

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
            convertView = inflater.inflate(R.layout.listview_one_student, null);

            viewHolder = new ViewHolder();
            viewHolder.student_Image = convertView.findViewById(R.id.student_image);
            viewHolder.student_Name = convertView.findViewById(R.id.text_Student_Name);
            viewHolder.student_Code = convertView.findViewById(R.id.text_Student_Code);
            viewHolder.student_DOB = convertView.findViewById(R.id.text_Student_DOB);
            viewHolder.student_Class = convertView.findViewById(R.id.text_Student_Class);
            viewHolder.student_Address = convertView.findViewById(R.id.text_Student_Address);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = list.get(position);
        viewHolder.student_Name.setText(student.getStudent_Name());
        viewHolder.student_Code.setText(student.getStudent_Code());
        viewHolder.student_DOB.setText(student.getStudent_DOB());
        viewHolder.student_Class.setText(student.getStudent_Class());
        viewHolder.student_Address.setText(student.getStudent_Address());

        return convertView;
    }

    public class ViewHolder{
        ImageView student_Image;
        TextView student_Name;
        TextView student_Code;
        TextView student_DOB;
        TextView student_Class;
        TextView student_Address;
    }
}
