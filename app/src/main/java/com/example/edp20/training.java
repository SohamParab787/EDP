package com.example.edp20;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class training extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(training.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Candle Making", R.string.candle, "₹1000", R.drawable.cnd_detail,  R.string.Candletime);
        dataList.add(androidData);

        androidData = new DataClass("Spices Making", R.string.spices, "₹1250", R.drawable.sp_detail, R.string.Spicestime);
        dataList.add(androidData);

        androidData = new DataClass("Palm Leaf Article Making", R.string.palm, "₹2000", R.drawable.pm_detail,  R.string.Palmtime);
        dataList.add(androidData);

        androidData = new DataClass("Perfume Making", R.string.perfume, "₹1750", R.drawable.prf_detail, R.string.Perfumetime);
        dataList.add(androidData);

        androidData = new DataClass("Chocolate Making", R.string.chocolate, "₹2500", R.drawable.cho_detail,  R.string.Chocotime);
        dataList.add(androidData);

        adapter = new MyAdapter(training.this, dataList);
        recyclerView.setAdapter(adapter);
    }

    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}