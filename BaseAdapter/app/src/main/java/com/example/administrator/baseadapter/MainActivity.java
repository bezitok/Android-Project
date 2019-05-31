package com.example.administrator.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.baseadapter.Adapter.Custom_BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listAlbum;

    int[] hinhAlbum = {R.drawable.aqua, R.drawable.aslongasyouloveme, R.drawable.nevergone, R.drawable.images, R.drawable.noname};
    String[] TenAlbum = {"Cháu lên ba", "Một hai ba", "In the end", "Vợ người ta", "Có khi nào rời xa"};
    String[] NgayPhatHanh = {"12/1/1999", "12/1/1939","11/1/1999","12/2/1999","12/1/1992"};
    List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlbum = findViewById(R.id.listView);
        albumList = new ArrayList<>();

        for(int i=0; i<TenAlbum.length; i++){
            Album album = new Album();
            album.setHinhAnh(hinhAlbum[i]);
            album.setTenAlbum(TenAlbum[i]);
            album.setNgayPhatHanh(NgayPhatHanh[i]);

            albumList.add(album);
        }

        Custom_BaseAdapter custom_baseAdapter = new Custom_BaseAdapter(getApplicationContext(), R.layout.custom_layout_list, albumList);
        custom_baseAdapter.notifyDataSetChanged();
        listAlbum.setAdapter(custom_baseAdapter);

        listAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Album: " + albumList.get(position).getTenAlbum() + "\n" + "Ngày phát hành: " + albumList.get(position).getNgayPhatHanh(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
