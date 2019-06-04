package com.example.listviewwithcontextmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Information_Screen extends AppCompatActivity {

    List<Student> studentList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);

        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        studentList = bundle.getParcelableArrayList("key");

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), R.layout.one_student_information, studentList);
        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
    }

    public class CustomAdapter extends ArrayAdapter<Student> {

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
            ViewHolder viewHolder ;
            View rowView = convertView;

            if(rowView == null){

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.one_student_information, null);

                viewHolder = new ViewHolder();

                viewHolder.studentImage = rowView.findViewById(R.id.student_image);
                viewHolder.studentName = rowView.findViewById(R.id.text_Student_Name);
                viewHolder.studentPhoneNumber = rowView.findViewById(R.id.text_Student_PhoneNumber);
                viewHolder.studentPhoneNumber = rowView.findViewById(R.id.text_Student_Address);

                rowView.setTag(viewHolder);

            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Student student = studentList.get(position);
            viewHolder.studentImage.setImageResource(student.getStudentImage());
            viewHolder.studentName.setText(student.getName());
            viewHolder.studentPhoneNumber.setText(String.valueOf(student.getPhone()));
            viewHolder.studentAddress.setText(student.getAddress());

            return rowView;
        }

    }

    public class ViewHolder {
        ImageView studentImage;
        TextView studentName, studentPhoneNumber, studentAddress;
    }
}
