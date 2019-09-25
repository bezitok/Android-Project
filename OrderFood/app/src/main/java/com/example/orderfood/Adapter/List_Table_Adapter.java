package com.example.orderfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.DTO.Table_DTO;
import com.example.orderfood.R;

import java.util.ArrayList;
import java.util.List;

public class List_Table_Adapter extends BaseAdapter implements View.OnClickListener {

    Context context;
    int layout;
    List<Table_DTO> tableList;
    ViewHolder viewHolder;

    public List_Table_Adapter(Context context, int layout, List<Table_DTO> list) {
        this.context = context;
        this.layout = layout;
        this.tableList = list;
    }

    @Override
    public int getCount() {
        return tableList.size();
    }

    @Override
    public Object getItem(int position) {
        return tableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tableList.get(position).getId_table();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.a_table_layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.tableName = convertView.findViewById(R.id.a_table_txt_table_name);
            viewHolder.tableImage = convertView.findViewById(R.id.a_table_img_table_image);
            viewHolder.btn_Order = convertView.findViewById(R.id.a_table_img_table_order);
            viewHolder.btn_Pay = convertView.findViewById(R.id.a_table_img_table_pay);
            viewHolder.btn_Hide = convertView.findViewById(R.id.a_table_img_table_hide);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (tableList.get(position).isTable_selected()) {
            displayButton();
        } else {
            hideButton();
        }

        Table_DTO table = tableList.get(position);
        viewHolder.tableName.setText(table.getTableName());
        viewHolder.tableImage.setTag(position);

        viewHolder.tableImage.setOnClickListener(this);

        return convertView;
    }

    public void displayButton(){
        viewHolder.btn_Order.setVisibility(View.VISIBLE);
        viewHolder.btn_Pay.setVisibility(View.VISIBLE);
        viewHolder.btn_Hide.setVisibility(View.VISIBLE);
    }

    public void hideButton(){
        viewHolder.btn_Order.setVisibility(View.INVISIBLE);
        viewHolder.btn_Pay.setVisibility(View.INVISIBLE);
        viewHolder.btn_Hide.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewHolder = (ViewHolder) ((View) v.getParent()).getTag();
        switch (id) {
            case R.id.a_table_img_table_image:
                int pos = (int) v.getTag();
                tableList.get(pos).setTable_selected(true);
                displayButton();
                break;
        }
    }

    public class ViewHolder {
        TextView tableName;
        ImageView tableImage;
        ImageView btn_Order;
        ImageView btn_Pay;
        ImageView btn_Hide;
    }
}
