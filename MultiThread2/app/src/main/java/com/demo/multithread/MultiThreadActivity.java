package com.demo.multithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadActivity extends AppCompatActivity {

    private Button mStartButton;
    private TextView mThreadResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartButton = findViewById(R.id.btn_start);
        mThreadResultTextView = findViewById(R.id.tv_thread);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartMultiThreadWithThreadPool();
            }
        });
    }

    /**
     * Chạy 20 thread đưa vào trong phương thức startMultiThread() được khởi tạo trong ApplicationProject.java
     */
    private void onStartMultiThreadWithThreadPool() {
        List<Runnable> arrThread = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            final int finalI = i;
            arrThread.add(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mThreadResultTextView.setText(mThreadResultTextView.getText().toString() + " - " + finalI);
                        }
                    });

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        ApplicationProject.getInstance().startMultiThread(arrThread);

    }
}
