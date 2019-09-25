package com.example.orderfood.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orderfood.DAO.Table_DAO;
import com.example.orderfood.R;

public class Add_Table extends AppCompatActivity {

    EditText edt_add_table;
    Button btn_Confirm;
    Table_DAO table_dao;
    public static final String ADD_RESULT = "addResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_table);

        initWidget();

        table_dao = new Table_DAO(Add_Table.this);

    }

    public void initWidget(){
        edt_add_table = findViewById(R.id.add_table_edt_table_name);
        btn_Confirm = findViewById(R.id.add_table_btn_Confirm);
    }

    public void addTableConfirm(View view) {

        String tableName = edt_add_table.getText().toString();
        if(tableName.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Add_Table.this);
            builder.setCancelable(false);
            builder.setTitle("Alert");
            builder.setMessage("Table name can't be empty");
            builder.setPositiveButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else {
            boolean check = table_dao.addTable(tableName);
            Intent intent = new Intent();
            intent.putExtra(ADD_RESULT, check);
            setResult(RESULT_OK, intent);
            finish();
        }


    }
}
