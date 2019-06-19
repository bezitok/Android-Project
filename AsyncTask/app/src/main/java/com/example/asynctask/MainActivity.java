package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                new CongViec().execute();
            }
        });
    }

    private class CongViec extends AsyncTask<Void, String, String>{

        //Hàm chuẩn bị

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Bắt đầu." + "\n");
        }


        //Hàm xử lý chính, bắt buộc phải có
        @Override
        protected String doInBackground(Void... voids) {

            for(int i=0; i<5; i++){

                try {
                    Thread.sleep(2000);
                    publishProgress("Đếm: " + i + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return "Đã xong.\n";
        }


        //Hàm cập nhật tiến độ của công việc
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            textView.append(values[0]);
        }


        //Hàm trả ra kết quả của công việc
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.append(s);
        }
    }
}
