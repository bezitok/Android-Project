package com.example.orderfood.Fragments;

import android.app.Activity;
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
import android.widget.Toast;

import com.example.orderfood.Activities.Add_Table;
import com.example.orderfood.Activities.Home;
import com.example.orderfood.Adapter.List_Table_Adapter;
import com.example.orderfood.DAO.Table_DAO;
import com.example.orderfood.DTO.Table_DTO;
import com.example.orderfood.R;

import java.util.List;

public class DisplayTable_Fragment extends Fragment {

    public static final int REQUEST_CODE = 1;

    GridView gridView;

    List<Table_DTO> tableList;

    Table_DAO table_dao;

    List_Table_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.display_table_fragment, null);

        setHasOptionsMenu(true);

        ((Home)getActivity()).getSupportActionBar().setTitle(R.string.item_menu_add_table);

        gridView = fragment.findViewById(R.id.gridView_Display_Table);
        table_dao = new Table_DAO(getActivity());
        displayTable();

        return fragment;
    }

    private void displayTable(){
        tableList = table_dao.getAllTableInfo();

        adapter = new List_Table_Adapter(getActivity(), R.layout.a_table_layout, tableList);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem menuAddTable = menu.add(1, R.id.item_menu_add_table, 1, R.string.item_menu_add_table);

        menuAddTable.setIcon(R.drawable.addtable);
        menuAddTable.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.item_menu_add_table:
                Intent intent = new Intent(getActivity(), Add_Table.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;

        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Intent intent = data;
            boolean check = intent.getBooleanExtra(Add_Table.ADD_RESULT, false);
            if (check){
                displayTable();
                Toast.makeText(getActivity(), "Add table successfully", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getActivity(), "Add failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
