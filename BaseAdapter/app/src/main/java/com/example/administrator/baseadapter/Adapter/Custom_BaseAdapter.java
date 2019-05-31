package com.example.administrator.baseadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.baseadapter.Album;
import com.example.administrator.baseadapter.R;

import java.util.List;

public class Custom_BaseAdapter extends BaseAdapter {

    Context context;
    int resource;
    List<Album> albumList;

    public Custom_BaseAdapter(Context context, int resource, List<Album> object) {
        this.context = context;
        this.resource = resource;
        this.albumList = object;
    }

    @Override
    public int getCount() {
        return albumList.size(); //Trả ra số Item sẽ được hiển thị trong ListView
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource, parent, false);
        ImageView hinhAlbum = convertView.findViewById(R.id.hinhAlbum);
        TextView tenAlbum = convertView.findViewById(R.id.tenAlbum);
        TextView ngayPhatHanh = convertView.findViewById(R.id.ngayPhatHanh);

        hinhAlbum.setImageResource(albumList.get(position).getHinhAnh());
        tenAlbum.setText("Tên Album: " + albumList.get(position).getTenAlbum());
        ngayPhatHanh.setText(albumList.get(position).getNgayPhatHanh());
        return convertView;
    }
}
