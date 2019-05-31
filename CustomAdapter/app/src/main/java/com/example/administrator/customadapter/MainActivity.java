package com.example.administrator.customadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listAlbum;
    int[] hinhAlbum = {R.drawable.aqua, R.drawable.aslongasyouloveme, R.drawable.nevergone, R.drawable.images, R.drawable.noname};
    String[] TenAlbum = {"Cháu lên ba", "Một hai ba", "In the end", "Vợ người ta", "Có khi nào rời xa"};
    String[] NgayPhatHanh = {"12/1/1999", "12/1/1939","11/1/1999","12/2/1999","12/1/1992"};
    List<Album> danhsachAlbum = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlbum = findViewById(R.id.listAlbum);
        for(int i=0; i<TenAlbum.length; i++){
            Album album = new Album();
            album.setHinhAnh(hinhAlbum[i]);
            album.setTenAlbum(TenAlbum[i]);
            album.setNgayPhatHanh(NgayPhatHanh[i]);

            danhsachAlbum.add(album);
        }

        CustomAdapter adapterAlbum = new CustomAdapter(this, R.layout.custom_adapter_listview, danhsachAlbum);
        adapterAlbum.notifyDataSetChanged();
        listAlbum.setAdapter(adapterAlbum);
    }

    public class CustomAdapter extends ArrayAdapter<Album>{

        Context context;
        int resource;
        List<Album> listAlbum = new ArrayList<>();

        public CustomAdapter( Context context, int resource, List<Album> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.listAlbum = objects;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(resource, parent, false);
            ImageView hinhAlbum = rowItem.findViewById(R.id.hinhAlbum);
            TextView tenAlbum = rowItem.findViewById(R.id.tenAlbum);
            TextView ngayPhatHanh = rowItem.findViewById(R.id.ngayPhatHanh);

            hinhAlbum.setImageResource(listAlbum.get(position).getHinhAnh());
            tenAlbum.setText("Tên Album: "+listAlbum.get(position).getTenAlbum());
            ngayPhatHanh.setText(listAlbum.get(position).getNgayPhatHanh());

            return rowItem;
        }
    }
}
