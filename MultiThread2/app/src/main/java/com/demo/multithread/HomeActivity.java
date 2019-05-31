package com.demo.multithread;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public void onDirectMultiThread(View view) {
        Intent intent = new Intent(HomeActivity.this, MultiThreadActivity.class);
        startActivity(intent);
    }

    public void onDirectAsyncTask(View view) {
        Intent intent = new Intent(HomeActivity.this, AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void onDirectHandler(View view) {
        Intent intent = new Intent(HomeActivity.this, HandlerActivity.class);
        startActivity(intent);
    }
}
