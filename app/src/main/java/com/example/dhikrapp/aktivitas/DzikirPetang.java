package com.example.dhikrapp.aktivitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.dhikrapp.R;
import com.example.dhikrapp.adapter.ListAdapterDataDhikirPetang;
import com.example.dhikrapp.getdata.ItemDataDhikirPetang;
import com.example.dhikrapp.model.Data;

import java.util.ArrayList;

public class DzikirPetang extends AppCompatActivity {

    private RecyclerView rvData;
    private ArrayList<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_petang);

        getSupportActionBar().setTitle("Dzikir Petang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2CA8B4"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        rvData = findViewById(R.id.rvData);
        rvData.setHasFixedSize(true);

        list.addAll(ItemDataDhikirPetang.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        ListAdapterDataDhikirPetang listAdapterData = new ListAdapterDataDhikirPetang(list);
        rvData.setAdapter(listAdapterData);
    }
}