package com.example.viewpager.Adapter_ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.viewpager.Fragment.Page1;
import com.example.viewpager.Fragment.Page2;
import com.example.viewpager.Fragment.Page3;
import com.example.viewpager.Fragment.Page4;

import java.util.List;

public class Adapter_ViewPager extends FragmentStatePagerAdapter {

//    List<Fragment> fragments;

    public Adapter_ViewPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
//        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Page1();
            case 1:
                return new Page2();
            case 2:
                return new Page3();
            case 3:
                return new Page4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
