package com.example.intentservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Intent_Service extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public Intent_Service() {
        super("My intent service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            int count = 0;
            while (count<20){
                try {
                    wait(1000);
                    Log.e("Intent Service", "" + count);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service dừng", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
