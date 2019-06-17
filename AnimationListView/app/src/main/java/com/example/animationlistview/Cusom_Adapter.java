package com.example.animationlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Cusom_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Legend> list;

    public Cusom_Adapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.one_legend, null);

            viewHolder = new ViewHolder();

            viewHolder.image = convertView.findViewById(R.id.imageLegend);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.club = convertView.findViewById(R.id.club);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Legend legend = list.get(position);
        viewHolder.image.setImageResource(legend.getImage());
        viewHolder.name.setText(legend.getName());
        viewHolder.club.setText(legend.getClub());

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.listview_animation);
        convertView.startAnimation(animation);

        return convertView;
    }

    public class ViewHolder{
        ImageView image;
        TextView name;
        TextView club;
    }
}
