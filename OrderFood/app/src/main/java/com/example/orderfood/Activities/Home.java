package com.example.orderfood.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.orderfood.Fragments.DisplayMenu_Fragment;
import com.example.orderfood.Fragments.DisplayTable_Fragment;
import com.example.orderfood.R;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    TextView txt_UserName;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_main_layout);
        navigationView = findViewById(R.id.navigation_View);
        View view = navigationView.inflateHeaderView(R.layout.header_layout);
        txt_UserName = view.findViewById(R.id.drawerLayout_UserName);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(Home.this, drawerLayout, R.string.open, R.string.close);
        drawerToggle.syncState();

        navigationView.setItemIconTintList(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(Home.this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Log_In.USERNAME);
        txt_UserName.setText("Staff: " + userName);


        fragmentManager = getSupportFragmentManager();
        DisplayTable_Fragment displayTable = new DisplayTable_Fragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, displayTable);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.menu_home:
                DisplayTable_Fragment displayTable = new DisplayTable_Fragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_layout, displayTable);
                fragmentTransaction.commit();

                drawerLayout.closeDrawers();
                break;
            case R.id.menu_menu:
                DisplayMenu_Fragment displayMenu = new DisplayMenu_Fragment();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.content_layout, displayMenu);
                fragmentTransaction1.commit();

                drawerLayout.closeDrawers();
                break;
        }

        return false;
    }
}
