package com.example.orderfood.Adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.Activities.Home;
import com.example.orderfood.DAO.KindOfFood_DAO;
import com.example.orderfood.DTO.KindOfFood_DTO;
import com.example.orderfood.R;

import java.util.List;

public class Display_KindOfFood_Have_Image_Adapter extends BaseAdapter {

    Context context;
    int layout;
    List<KindOfFood_DTO> kindOfFood_List;
    ViewHolder viewHolder;
    KindOfFood_DAO kindOfFood_dao;

    public Display_KindOfFood_Have_Image_Adapter(Context context, int layout, List<KindOfFood_DTO> kindOfFood_List) {
        this.context = context;
        this.layout = layout;
        this.kindOfFood_List = kindOfFood_List;
        kindOfFood_dao = new KindOfFood_DAO(context);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.a_food_layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.kindOfFood_Image = convertView.findViewById(R.id.a_food_img);
            viewHolder.kindOfFood_Name = convertView.findViewById(R.id.a_food_txt_name);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        KindOfFood_DTO kindOfFood = kindOfFood_List.get(position);

        int id = kindOfFood.getId_KindOfFood();
        String image  = kindOfFood_dao.getKindOfFoodImage(id);
        Uri uri = Uri.parse(image);

        viewHolder.kindOfFood_Name.setText(kindOfFood.getKindOfFoof_Name());

//        viewHolder.kindOfFood_Image.setImageURI(uri);

        return convertView;
    }

    public class ViewHolder{
        ImageView kindOfFood_Image;
        TextView kindOfFood_Name;
    }
}
