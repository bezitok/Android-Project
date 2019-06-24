package com.example.xmlparser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xmlparser.BaiViet;
import com.example.xmlparser.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    List<BaiViet> list;

    public CustomAdapter(Context context, int resource, List<BaiViet> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(resource, null);

        TextView textTitle = view.findViewById(R.id.txtTieuDe);
        TextView textNgayDang = view.findViewById(R.id.txtNgayDang);
        TextView textNoiDung = view.findViewById(R.id.txtNoiDung);

        textTitle.setText(list.get(position).getTitle());
        textNgayDang.setText(list.get(position).getPubdate());
        textNoiDung.setText(list.get(position).getDescription());

        return view;
    }
}
