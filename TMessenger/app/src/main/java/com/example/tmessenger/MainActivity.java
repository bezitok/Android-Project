package com.example.tmessenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button buttonChat, buttonLogin;
    EditText editText;
    List<String> listMessages;
    ChatAdapter chatAdapter;
    String URL_SERVER = "http://192.168.1.77:1234";
    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("http://192.168.1.77:1234");
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSocket.connect();
        mSocket.on("receiver_message", onNewMessage);

        buttonLogin = findViewById(R.id.btn_login);
        buttonChat = findViewById(R.id.btn_chat);
        editText = findViewById(R.id.edt_name);
        listMessages = new ArrayList<>();
        recyclerView = findViewById(R.id.rc_chat);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(listMessages);
        recyclerView.setAdapter(chatAdapter);
    }
}
