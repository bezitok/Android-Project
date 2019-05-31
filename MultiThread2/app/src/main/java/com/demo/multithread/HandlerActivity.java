package com.demo.multithread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {
    private static final String TAG = HandlerActivity.class.getName();
    private ProgressBar mProgressBar;
    private TextView mResultTextView;

    private static String DATA_BUNDLE = "DATA_BUNDLE";
    private Handler mMessageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // Chạy các câu lệnh trong phương thức này khi mMessageHandler gọi send message
            mResultTextView.setText("Nhận message success ==> " + msg.getData().getString(DATA_BUNDLE));
            if (msg.getData().getString(DATA_BUNDLE).equals("1")) {
                mProgressBar.setVisibility(View.GONE);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_activity);
        mProgressBar = findViewById(R.id.progressbar);
        mResultTextView = findViewById(R.id.tv_result);
    }

    // Tạo 1 thread để xử lí đếm ngược 10 giây
    public void onStartHandler(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        new Thread() {
            @Override
            public void run() {
                super.run();
                int count = 10;
                while (count > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString(DATA_BUNDLE, count + "");
                    Message message = new Message();
                    message.setData(bundle);
                    mMessageHandler.sendMessage(message);
                    count -= 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
