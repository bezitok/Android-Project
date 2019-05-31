package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class Music_Service extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service đang chạy", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.i_know_you_know);
        mediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service đã dừng", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
