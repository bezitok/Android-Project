package com.example.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Bound_Service service;
    EditText editText1, editText2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);

        button = findViewById(R.id.buttonGetData);
        button.setOnClickListener(this);

        service = new Bound_Service();

        Intent intent = new Intent(MainActivity.this, Bound_Service.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Bound_Service.LocalBinder localBinder = (Bound_Service.LocalBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        float number1 = Float.parseFloat(editText1.getText().toString());
        float number2 = Float.parseFloat(editText2.getText().toString());
        float sum = service.AddTwoNumber(number1, number2);
        textView.setText("Kết quả: " +sum);
    }
}
