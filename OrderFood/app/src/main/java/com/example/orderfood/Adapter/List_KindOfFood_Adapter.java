package com.example.orderfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.orderfood.DTO.KindOfFood_DTO;
import com.example.orderfood.R;

import java.util.List;

public class List_KindOfFood_Adapter extends BaseAdapter {

    Context context;
    int layout;
    List<KindOfFood_DTO> kindOfFood_List;
    ViewHolder viewHolder;

    public List_KindOfFood_Adapter(Context context, int layout, List<KindOfFood_DTO> list){
        this.context = context;
        this.layout = layout;
        this.kindOfFood_List = list;
    }

    @Override
    public int getCount() {
        return kindOfFood_List.size();
    }

    @Override
    public Object getItem(int position) {
        return kindOfFood_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return kindOfFood_List.get(position).getId_KindOfFood();
    }

    public class ViewHolder{
        TextView txt_kindOfFood_Name;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.a_kind_of_food_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txt_kindOfFood_Name = convertView.findViewById(R.id.spinner_kindOfFood_Name);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        KindOfFood_DTO kindOfFood = kindOfFood_List.get(position);
        viewHolder.txt_kindOfFood_Name.setText(kindOfFood.getKindOfFoof_Name());
        viewHolder.txt_kindOfFood_Name.setTag(kindOfFood.getId_KindOfFood());

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.a_kind_of_food_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txt_kindOfFood_Name = convertView.findViewById(R.id.spinner_kindOfFood_Name);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        KindOfFood_DTO kindOfFood = kindOfFood_List.get(position);
        viewHolder.txt_kindOfFood_Name.setText(kindOfFood.getKindOfFoof_Name());
        viewHolder.txt_kindOfFood_Name.setTag(kindOfFood.getId_KindOfFood());

        return convertView;
    }
}
