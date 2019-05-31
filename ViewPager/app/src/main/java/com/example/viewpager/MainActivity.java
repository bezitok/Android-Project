package com.example.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viewpager.Adapter_ViewPager.Adapter_ViewPager;
import com.example.viewpager.AnimationViewPager.DepthAnimation;
import com.example.viewpager.Fragment.Page1;
import com.example.viewpager.Fragment.Page2;
import com.example.viewpager.Fragment.Page3;
import com.example.viewpager.Fragment.Page4;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        fragments = new ArrayList<>();

//        Page1 page1 = new Page1();
//        Page2 page2 = new Page2();
//        Page3 page3 = new Page3();
//        Page4 page4 = new Page4();
//
//        fragments.add(page1);
//        fragments.add(page2);
//        fragments.add(page3);
//        fragments.add(page4);

        Adapter_ViewPager adapter_viewPager = new Adapter_ViewPager(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter_viewPager);
        viewPager.setPageTransformer(true, new DepthAnimation());

    }
}
