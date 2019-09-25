package com.example.orderfood.Activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orderfood.DAO.KindOfFood_DAO;
import com.example.orderfood.R;

public class Add_Kind_Of_Food extends AppCompatActivity {

    Button btn_Confirm;
    EditText edt_kindOfFood;
    KindOfFood_DAO kindOfFood_dao;
    public static final String RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kind_of_food);

        setTitle(R.string.kind_of_food_edt);

        btn_Confirm = findViewById(R.id.kind_of_food_btn_Confirm);
        edt_kindOfFood = findViewById(R.id.kind_of_food_edt_kind_of_food);

        kindOfFood_dao = new KindOfFood_DAO(Add_Kind_Of_Food.this);

    }

    public void addKindOfFood(View view) {
        String kindOfFood = edt_kindOfFood.getText().toString();

        if(kindOfFood.isEmpty()){
            edt_kindOfFood.setError("Can't be empty");
        }else{
            boolean check = kindOfFood_dao.addKindOfFood(kindOfFood);
            Intent intent = new Intent();
            intent.putExtra(RESULT, check);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
