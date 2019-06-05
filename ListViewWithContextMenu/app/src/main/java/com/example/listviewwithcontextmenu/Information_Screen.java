package com.example.listviewwithcontextmenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
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

public class Information_Screen extends AppCompatActivity {

    ArrayList<Student> studentList = new ArrayList<>();
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<Student> studentArrayList = new ArrayList<>();
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_screen);

        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        studentList = bundle.getParcelableArrayList("key");

        customAdapter = new CustomAdapter(getApplicationContext(), R.layout.one_student_information, studentList);
        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
        fragmentManager = getSupportFragmentManager();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                studentArrayList.clear();
                studentArrayList.add(studentList.get(position));
                registerForContextMenu(listView);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                studentArrayList.clear();
                studentArrayList.add(studentList.get(position));
                final Intent intent = new Intent(Information_Screen.this, One_Student_Detail.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("studentList", studentArrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
                viewHolder.studentAddress = rowView.findViewById(R.id.text_Student_Address);

                rowView.setTag(viewHolder);

            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Student student = list.get(position);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int pos = menuInfo.position;
        switch (item.getItemId()){
            case R.id.detail:
                final Intent intent = new Intent(Information_Screen.this, One_Student_Detail.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("studentList", studentArrayList);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.edit:
                break;
            case R.id.delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(Information_Screen.this);
                builder.setTitle("Alert");
                builder.setMessage("Xóa học viên khỏi danh sách?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        studentList.remove(pos);
                        customAdapter.notifyDataSetChanged();
                        Toast.makeText(Information_Screen.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                        if(studentList.size()==0){
                            Intent intent1 = new Intent(Information_Screen.this, Empty_Information_Screen.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


        }
        return super.onContextItemSelected(item);
    }
}
