package com.example.communicationfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_1.CommunicateFragment {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment_1 fragment_1 = new Fragment_1();


//        send dữ liệu
//        Bundle bundle = new Bundle();
//        bundle.putString("xin chào", "Đây là dữ liệu được gửi");
//        fragment_1.setArguments(bundle);



        fragmentTransaction.add(R.id.linearActivity, fragment_1);

        fragmentTransaction.commit();
    }

    @Override
    public void SendData(String data) {
        Fragment_2 fragment_2 = new Fragment_2();
        Bundle bundle = new Bundle();
        bundle.putString("dữ liệu", data);
        fragment_2.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearActivity, fragment_2);
        fragmentTransaction.commit();
    }
}
