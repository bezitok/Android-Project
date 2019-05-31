package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class Bound_Service extends Service {

    IBinder iBinder = new LocalBinder(); //Tạo liên kết tới client

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class LocalBinder extends Binder{

        LocalBinder getLocalBinder(){
            return LocalBinder.this; //Phương thức khởi tạo khi client gọi tới các phương thức của service
        }
    }

    public String Hello(){
        return "Hello everyone";
    }

    public float AddTwoNumber(float a, float b){
        return a+b;
    }
}
