package com.example.administrator.multimedia;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

public class Second_Activity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_screen);
        try {
            mediaPlayer.prepare();

            int maxVolume = 50;
            int minVolume = 25;
            float logl = (float) (Math.log(maxVolume - minVolume) / Math.log(maxVolume));
            mediaPlayer.setVolume(0, 1 - logl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        reg
    }

    public void Play(View view) {
        if (mediaPlayer != null){
            mediaPlayer.start();
        }else {
            mediaPlayer = MediaPlayer.create(Second_Activity.this, R.raw.rose);
        }
    }

    public void Pause(View view) {
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void Resume(View view) {
        if(mediaPlayer != null){
        }
    }

    public void Release(View view) {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void PlayFromInternet(View view) {
        mediaPlayer = MediaPlayer.create(Second_Activity.this, R.raw.rose);
        mediaPlayer.start();
    }

}
