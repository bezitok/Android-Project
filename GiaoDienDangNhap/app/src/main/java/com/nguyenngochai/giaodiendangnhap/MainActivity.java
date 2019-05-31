package com.nguyenngochai.giaodiendangnhap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FacebookLogin(View view) {
        Toast.makeText(this,"Bạn đã đăng nhập bằng Facebook",Toast.LENGTH_LONG).show();
    }

    public void TwitterLogin(View view) {
        Toast.makeText(this,"Bạn đã đăng nhập bằng Twitter",Toast.LENGTH_LONG).show();
    }

    public void Register(View view) {
        Toast.makeText(this,"Đăng kí thành công",Toast.LENGTH_LONG).show();
    }

    public void btnDangNhap(View view) {
        Toast.makeText(this,"Xin chào bạn hải",Toast.LENGTH_LONG).show();
    }
}
