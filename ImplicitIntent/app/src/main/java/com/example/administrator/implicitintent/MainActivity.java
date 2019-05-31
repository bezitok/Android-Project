package com.example.administrator.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.buttonSend);
        button2 = findViewById(R.id.buttonCall);
    }

    public void Send(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Xin chào các bạn");
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void Call(View view) {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:0966451614"));
            startActivity(intent);
        } catch (SecurityException e) {
            Log.e("Error", "Lỗi nhé");
            e.printStackTrace();
        }
    }
}
