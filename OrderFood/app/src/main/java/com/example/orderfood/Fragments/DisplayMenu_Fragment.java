package com.example.orderfood.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.orderfood.Activities.Add_Menu;
import com.example.orderfood.Activities.Home;
import com.example.orderfood.Adapter.Display_KindOfFood_Have_Image_Adapter;
import com.example.orderfood.DAO.KindOfFood_DAO;
import com.example.orderfood.DTO.KindOfFood_DTO;
import com.example.orderfood.R;

import java.util.ArrayList;
import java.util.List;

public class DisplayMenu_Fragment extends Fragment {

    GridView gridView;
    List<KindOfFood_DTO> kindOfFood_List;
    KindOfFood_DAO kindOfFood_dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.display_menu_fragment, container, false);

        setHasOptionsMenu(true);

        ((Home)getActivity()).getSupportActionBar().setTitle(R.string.item_menu_add_menu);

        gridView = fragment.findViewById(R.id.gridView_Display_Menu);

        kindOfFood_dao = new KindOfFood_DAO(getActivity());
        kindOfFood_List = kindOfFood_dao.getAllKindOfFoodInfo();

        Display_KindOfFood_Have_Image_Adapter adapter = new Display_KindOfFood_Have_Image_Adapter(getActivity(), R.layout.a_food_layout, kindOfFood_List);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem menuAddMenu = menu.add(1, R.id.item_menu_add_menu, 1, R.string.item_menu_add_menu);

        menuAddMenu.setIcon(R.drawable.add_menu);
        menuAddMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item_menu_add_menu:
                Intent intent = new Intent(getActivity(), Add_Menu.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}
