package com.example.administrator.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    BroadcastReceiver broadcastReceiver1, broadcastReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button1);

        broadcastReceiver1 = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Message done", Toast.LENGTH_SHORT).show();
            }
        };

        broadcastReceiver2 = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Log.e("Broadcast", "action =>" + intent.getAction());
                Toast.makeText(context, "Manchester United : " + intent.getAction(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onResume() {
        IntentFilter filter1 = new IntentFilter();
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction("Change Log");
        filter2.addAction("Hay lắm em");
        registerReceiver(broadcastReceiver2, filter2);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver2);
        super.onDestroy();
    }

    public void SendBroadCast(View view) {
        Intent intent1 = new Intent();
        Intent intent2 = new Intent();
        intent1.setAction("Change Log");
        intent2.setAction("Hay lắm em");
        sendBroadcast(intent1);
        sendBroadcast(intent2);

    }
}
