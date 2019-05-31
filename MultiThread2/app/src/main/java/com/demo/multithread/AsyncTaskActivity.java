package com.demo.multithread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {
    private static final String TAG = AsyncTaskActivity.class.getName();
    private ProgressBar mProgressBar;
    private TextView mResultTextView;

    private AsyncTask<Integer, Integer, Integer> mAsyncTaskDemo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctask_activity);
        mProgressBar = findViewById(R.id.progressbar);
        mResultTextView = findViewById(R.id.tv_result);
    }

    public void onStartAsyncTask(View view) {
        mAsyncTaskDemo = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // PHương thức này chứa các công việc cần chuẩn bị trước khi asynctask chạy
                mProgressBar.setVisibility(View.VISIBLE);
                mResultTextView.setText("START");
            }

            @Override
            protected Integer doInBackground(Integer... integers) {
                int count = integers[0];
                while (count > 0){
                    Log.e(TAG, "doInBackground ... " + count);
                    publishProgress(count);
                    count -= 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return integers[0];
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                mResultTextView.setText("PROGRESSING ... " + values[0]);
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);

                mResultTextView.setText("COMPLETED : " + integer);
                mProgressBar.setVisibility(View.GONE);
            }
        };

        mAsyncTaskDemo.execute(10);
    }
}
