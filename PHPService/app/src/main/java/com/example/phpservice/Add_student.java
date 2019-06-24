package com.example.phpservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add_student extends AppCompatActivity {

    EditText edt_name, edt_DOB, edt_address;
    Button btn_Confirm, btn_Cancel;
    String url = "http://dropchatmessenger.epizy.com/webservice/insert.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_student);

        initWidget();

    }

    public void initWidget(){
        edt_address = findViewById(R.id.edt_address);
        edt_DOB = findViewById(R.id.edt_DOB);
        edt_name = findViewById(R.id.edt_name);
        btn_Confirm = findViewById(R.id.btn_Confirm);
        btn_Cancel = findViewById(R.id.btn_Cancel);
    }

    public void AddStudent(View view) {
        String student_name = edt_name.getText().toString();
        String student_DOB = edt_DOB.getText().toString();
        String student_Address = edt_address.getText().toString();
        if(student_name.isEmpty() || student_DOB.isEmpty() || student_Address.isEmpty()){
            Toast.makeText(Add_student.this, "Không được để trống các trường", Toast.LENGTH_LONG).show();
        }else {
            Add(url);
        }
    }

    public void Cancel(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Add_student.this);
        builder.setCancelable(false);
        builder.setTitle("Warning");
        builder.setMessage("Xác nhận hủy?");
        builder.setPositiveButton("No", null);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Add(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(Add_student.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("Success")){
                    Toast.makeText(Add_student.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Add_student.this, MainActivity.class));
                }else{
                    Toast.makeText(Add_student.this, "Có lỗi", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Add_student.this, "Lỗi", Toast.LENGTH_LONG).show();
                Log.d("AAA", error.toString());
            }
        }){
            //Đẩy lên dữ liệu dạng key - value
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                //gửi thông tin người dùng nhập lên PHP
                params.put("hotenSV", edt_name.getText().toString());
                params.put("namsinhSV", edt_DOB.getText().toString());
                params.put("diachiSV", edt_address.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
