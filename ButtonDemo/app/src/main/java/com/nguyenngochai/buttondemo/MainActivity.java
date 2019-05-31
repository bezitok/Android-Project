package com.nguyenngochai.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnThongBao, btnXinChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThongBao = (Button) findViewById(R.id.btnThongBao);
        btnXinChao = (Button) findViewById(R.id.btnXinChao);
        btnThongBao.setOnClickListener(this);
        btnXinChao.setOnClickListener(this);
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"xin chào các bạn, đây là button xuất thông báo " ,Toast.LENGTH_LONG).show();
            }
        });
        btnXinChao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"xin chào các bạn, đây là button xin chào " ,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    public void XuatThongBao(View view){
        String getContentView = String.valueOf(view.getId());
        //String getContentView = String.valueOf(view.getId()) --> lấy Id của button gọi hàm xuất thông báo
        switch (view.getId()){
            case R.id.btnThongBao:
                Toast.makeText(MainActivity.this,"xin chào các bạn, đây là button xuất thông báo " ,Toast.LENGTH_LONG).show();
                break;
            case R.id.btnXinChao:
                Toast.makeText(MainActivity.this,"xin chào các bạn, đây là button xin chào " ,Toast.LENGTH_LONG).show();
        }
//        Button btnXuatThongBao = (Button) view;
//        String getTextButton = btnXuatThongBao.getText().toString();
//        Toast.makeText(MainActivity.this,"xin chào các bạn " + getTextButton,Toast.LENGTH_LONG).show();
    }
}
