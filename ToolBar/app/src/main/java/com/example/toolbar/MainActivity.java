package com.example.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        MenuItem searchView = menu.findItem(R.id.searchView);
        SearchView searchView1 = (SearchView) searchView.getActionView();
        searchView1.setOnQueryTextListener(MainActivity.this);

        ShareActionProvider actionProvider = (ShareActionProvider) menu.findItem(R.id.share);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn thêm", Toast.LENGTH_LONG).show();
                break;
            case R.id.edit:
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn sửa", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        return false;
    }
}
