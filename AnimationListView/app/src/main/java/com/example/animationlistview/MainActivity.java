package com.example.animationlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Legend> legendsList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        legendsList.add(new Legend("David Beckam", "Manchester United", R.drawable.beckham));
        legendsList.add(new Legend("Lionel Messi", "Barcelona", R.drawable.messi));
        legendsList.add(new Legend("Christiano Ronaldo", "Real Madrid", R.drawable.ronaldo));
        legendsList.add(new Legend("Rio Ferdinand", "Manchester United", R.drawable.rio));
        legendsList.add(new Legend("Nemanja Vidic", "Manchester United", R.drawable.vidic));
        legendsList.add(new Legend("Pavel Nedved", "Juventus", R.drawable.nedved));
        legendsList.add(new Legend("David Beckam", "Manchester United", R.drawable.beckham));
        legendsList.add(new Legend("Lionel Messi", "Barcelona", R.drawable.messi));
        legendsList.add(new Legend("Christiano Ronaldo", "Real Madrid", R.drawable.ronaldo));
        legendsList.add(new Legend("Rio Ferdinand", "Manchester United", R.drawable.rio));
        legendsList.add(new Legend("Nemanja Vidic", "Manchester United", R.drawable.vidic));
        legendsList.add(new Legend("Pavel Nedved", "Juventus", R.drawable.nedved));
        legendsList.add(new Legend("David Beckam", "Manchester United", R.drawable.beckham));
        legendsList.add(new Legend("Lionel Messi", "Barcelona", R.drawable.messi));
        legendsList.add(new Legend("Christiano Ronaldo", "Real Madrid", R.drawable.ronaldo));
        legendsList.add(new Legend("Rio Ferdinand", "Manchester United", R.drawable.rio));
        legendsList.add(new Legend("Nemanja Vidic", "Manchester United", R.drawable.vidic));
        legendsList.add(new Legend("Pavel Nedved", "Juventus", R.drawable.nedved));

        Cusom_Adapter cusom_adapter = new Cusom_Adapter(this, R.layout.one_legend, legendsList);
        cusom_adapter.notifyDataSetChanged();
        listView.setAdapter(cusom_adapter);

    }
}
