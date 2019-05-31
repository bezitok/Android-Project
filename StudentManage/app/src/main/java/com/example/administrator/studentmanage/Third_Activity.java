package com.example.administrator.studentmanage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Third_Activity extends AppCompatActivity {

    ListView allStudentInfnormationList;

    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        allStudentInfnormationList = findViewById(R.id.allStudentInformation);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        studentList = bundle.getParcelableArrayList("key");

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.one_student_information, studentList);
        customAdapter.notifyDataSetChanged();
        allStudentInfnormationList.setAdapter(customAdapter);
        
        registerForContextMenu(allStudentInfnormationList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Gán Context Menu cho ListView
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Demo Menu");

        //Gán menu đã thiết kế cho sự kiện click theo từng item Listview
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Bạn vừa chọn xóa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Bạn vừa chọn sửa", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    public class CustomAdapter extends ArrayAdapter<Student>{

        Context context;
        int resource;
        List<Student> list;

        public CustomAdapter(Context context, int resource, List<Student> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.list = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            ViewHolder viewHolder = null;
            if(rowView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.one_student_information, null);

                viewHolder = new ViewHolder();
                viewHolder.studentImage = rowView.findViewById(R.id.oneStudentImage);
                viewHolder.studentName = rowView.findViewById(R.id.oneStudentName);
                viewHolder.studentAge = rowView.findViewById(R.id.oneStudentAge);
                viewHolder.studentAddress = rowView.findViewById(R.id.oneStudentAddress);
                rowView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Student student = studentList.get(position);
            viewHolder.studentImage.setImageResource(student.getStudentImage());
            viewHolder.studentName.setText(student.getStudentName());
            viewHolder.studentAge.setText(String.valueOf(student.getStudentAge()));
            viewHolder.studentAddress.setText(student.getStudentAddress());

            return rowView;
        }
    }

    public class ViewHolder{
        ImageView studentImage;
        TextView studentName;
        TextView studentAge;
        TextView studentAddress;
    }
}