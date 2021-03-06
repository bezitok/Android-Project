package com.example.tabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
public class MainActivity extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();
//Khởi tạo tab hình ảnh
        TabSpec photospec = tabHost.newTabSpec("HinhAnh");
//Thiết lập tên tab hiển thị và icon
        photospec.setIndicator("Hình ảnh", getResources().getDrawable(R.drawable.ic_action_library_music));
//Thiết lập nôi dung cho tab này là activity HinhAnhActivity.class
        Intent photosIntent = new Intent(this, HinhAnhActivity.class);
        photospec.setContent(photosIntent);
//Khởi tạo tab nghe nhạc
        TabSpec songspec = tabHost.newTabSpec("NgheNhac");
        songspec.setIndicator("Nghe nhạc", getResources().getDrawable(R.drawable.ic_action_library_music));
        Intent songsIntent = new Intent(this, BaiHatActivity.class);
        songspec.setContent(songsIntent);
//Khởi tạo tab xem phim
        TabSpec videospec = tabHost.newTabSpec("XemPhim");
        videospec.setIndicator("Xem phim", getResources().getDrawable(R.drawable.ic_action_library_music));
        Intent videosIntent = new Intent(this, PhimAnhActivity.class);
        videospec.setContent(videosIntent);
//Thêm các TabSpec trên vào TabHost
        tabHost.addTab(photospec); //Thêm tab hình ảnh
        tabHost.addTab(songspec); //Thêm tab nghe nhạc
        tabHost.addTab(videospec); //Thêm tab xem phim
    }
}
