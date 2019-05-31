package com.example.administrator.senddata;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    EditText editText1;
    Button button;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        button = findViewById(R.id.button1);




    }


    public void Add(View view) {
        arrayList.add(editText1.getText().toString());

        Toast.makeText(this, "Add success", Toast.LENGTH_LONG).show();
    }


    public void Show(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("key", arrayList);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
