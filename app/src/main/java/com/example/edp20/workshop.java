package com.example.edp20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class workshop extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(workshop.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Digital Marketing", R.string.dm, "₹700", R.drawable.wk_detail,  R.string.Digitime);
        dataList.add(androidData);

        androidData = new DataClass("Soap Making", R.string.soap, "₹850", R.drawable.ls_detail,  R.string.Soaptime);
        dataList.add(androidData);

        androidData = new DataClass("Import and Export", R.string.iae, "₹900", R.drawable.ime_detail,  R.string.IAEtime);
        dataList.add(androidData);

        androidData = new DataClass("Paper Bag Making", R.string.paper, "₹950", R.drawable.pb_detail, R.string.Papertime);
        dataList.add(androidData);

        androidData = new DataClass("Entrepreneur Awareness Programme", R.string.ent, "₹700", R.drawable.ed_detail,  R.string.Entretime);
        dataList.add(androidData);

        adapter = new MyAdapter(workshop.this, dataList);
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