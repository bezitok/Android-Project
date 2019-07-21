package com.example.usingsqlite.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.usingsqlite.DTO.Company_DTO;

import java.util.List;

public class Custom_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Company_DTO> list;

    public Custom_Adapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }


}
