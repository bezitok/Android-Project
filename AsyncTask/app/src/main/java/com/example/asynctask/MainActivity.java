package com.example.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnXuLy);
        textView = findViewById(R.id.textViewThongTin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DemoAsyncTask().execute(10);
            }
        });


    }

    private class DemoAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "AsyncTask đang chạy", Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int inputNumber = integers[0];
            for(int i=0; i<inputNumber; i++){
                publishProgress(i+1);
                SystemClock.sleep(1000);
            }

            String result = "Đã xong";

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int i = values[0];
            textView.setText("Đếm: " + i);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            textView.setText(result);
        }
    }
}
