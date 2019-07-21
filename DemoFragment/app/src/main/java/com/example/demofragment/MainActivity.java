package com.example.demofragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_1.Communicate{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_1 fragment_1 = new Fragment_1();
        fragmentTransaction.add(R.id.linear_layout, fragment_1);
        fragmentTransaction.commit();
    }

    @Override
    public void SendData(String data) {
        Fragment_2 fragment_2 = new Fragment_2();

        Bundle bundle = new Bundle();
        bundle.putString("key", data);
        fragment_2.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linear_layout, fragment_2);
        fragmentTransaction.commit();
    }
}
