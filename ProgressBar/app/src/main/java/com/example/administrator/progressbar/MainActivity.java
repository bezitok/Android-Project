package com.example.administrator.progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    Button button;
    Handler handle;
    int processing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.buttonProgress);

        handle = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                progressBar.setProgress(msg.what + 10);
            }
        }; //update
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (processing<100){
                    processing = progressBar.getProgress();
                    handle.sendEmptyMessage(processing);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
