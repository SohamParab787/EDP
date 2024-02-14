package com.example.edp20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class webinar extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(webinar.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Self Help Group Awareness", R.string.self, "₹450", R.drawable.shg_detail, R.string.selftime);
        dataList.add(androidData);

        androidData = new DataClass("Local to Global", R.string.ltg, "₹500", R.drawable.lg_detail, R.string.LTGtime);
        dataList.add(androidData);

        androidData = new DataClass("Women Empowerment", R.string.woman, "₹300", R.drawable.we_detail,R.string.womentime);
        dataList.add(androidData);

        androidData = new DataClass("Personality Development", R.string.per, "₹550", R.drawable.pd_detail, R.string.Personalitytime);
        dataList.add(androidData);

        androidData = new DataClass("Finance and Planning", R.string.fap, "₹350", R.drawable.fap_detail, R.string.Financetime);
        dataList.add(androidData);

        adapter = new MyAdapter(webinar.this, dataList);
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