package com.learn.mdessa.recyclerView;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.learn.mdessa.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.myAdapter;
import Model.listItems;

public class recyclerViewMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<listItems> listItems;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        for (int x =1;x<12;x++){
            listItems listItems1 = new listItems(
                    "name " + (x+1),
                    "description"
            );
           listItems.add(listItems1);
        }

        adapter = new myAdapter(this,listItems);
        recyclerView.setAdapter(adapter);
    }
}
