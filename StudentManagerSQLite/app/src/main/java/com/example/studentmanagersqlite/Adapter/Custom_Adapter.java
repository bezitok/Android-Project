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
            convertView = inflater.inflate(R.layout.one_student_information, null);

            viewHolder = new ViewHolder();
            viewHolder.student_Image = convertView.findViewById(R.id.one_student_information_imageView);
            viewHolder.student_Name = convertView.findViewById(R.id.one_student_information_textView1);
            viewHolder.student_Code = convertView.findViewById(R.id.one_student_information_textView2);
            viewHolder.student_DOB = convertView.findViewById(R.id.one_student_information_textView3);
            viewHolder.student_Class = convertView.findViewById(R.id.one_student_information_textView4);
            viewHolder.student_Address = convertView.findViewById(R.id.one_student_information_textView5);

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
