package com.example.administrator.contactapp;

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

import java.util.ArrayList;
import java.util.List;

public class Show_All_Contact_Information extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_contact_information);
        listView = findViewById(R.id.contactList);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<Contact> contactArrayList = bundle.getParcelableArrayList("key");

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.one_contact_information, contactArrayList);
        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
    }

    public class CustomAdapter extends ArrayAdapter<Contact>{

        Context context;
        int resource;
        List<Contact> contactArrayList ;

        public CustomAdapter(Context context, int resource, List<Contact> objects) {
            super(context, resource, objects);

            this.context = context;
            this.resource = resource;
            this.contactArrayList = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            ViewHolder viewHolder = null;
            if(rowView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.one_contact_information, null);
                viewHolder = new ViewHolder();
                viewHolder.contactImage = rowView.findViewById(R.id.contactImage);
                viewHolder.contactName = rowView.findViewById(R.id.contactName);
                viewHolder.contactNumber = rowView.findViewById(R.id.contactNumber);
                rowView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Contact contact = contactArrayList.get(position);
            viewHolder.contactImage.setImageResource(contact.getContactImage());
            viewHolder.contactName.setText(contact.getContactName());
            viewHolder.contactNumber.setText(contact.getContactNumber());
            return rowView;
        }
    }

    public class ViewHolder{
        ImageView contactImage;
        TextView contactName;
        TextView contactNumber;
    }
}
