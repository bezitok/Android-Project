package com.example.dropchatmessenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    Socket socket;
    JSONObject object;

    {
        try {
            socket = IO.socket("http://192.168.1.77:3000");
        }catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        socket.connect();

        socket.on("server-send-data", onReceiveData);

        socket.emit("client-send-data", "Hello World");
    }
    private Emitter.Listener onReceiveData = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    object = (JSONObject) args[0];
                    try {
                        String noidung = object.getString("noidung");
                        Toast.makeText(MainActivity.this, noidung, Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
}
