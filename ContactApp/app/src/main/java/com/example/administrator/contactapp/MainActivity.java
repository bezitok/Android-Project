package com.example.administrator.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button1, button2;
    ArrayList<Contact> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

    }

    public void AddContactInformation(View view) {
        Contact contact = new Contact();

        contact.setContactImage(R.drawable.icons8useraccount480);
        contact.setContactName(editText1.getText().toString());
        contact.setContactNumber(editText2.getText().toString());

        contactsList.add(contact);
        Toast.makeText(this,"Add successfully", Toast.LENGTH_LONG).show();
    }


    public void ShowAllContactInformation(View view) {
        Intent intent = new Intent(MainActivity.this, Show_All_Contact_Information.class);

        //Gửi dữ liệu sang màn hình thứ 2
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key", contactsList);
        intent.putExtras(bundle);

        //Chuyển sang màn hình thứ 2
        startActivity(intent);
    }
}
