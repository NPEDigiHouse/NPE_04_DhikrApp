package com.example.dhikrapp.aktivitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.dhikrapp.R;
import com.example.dhikrapp.adapter.ListAdapterDataDhikirPagi;
import com.example.dhikrapp.getdata.ItemDataDhikirPagi;
import com.example.dhikrapp.model.Data;

import java.util.ArrayList;

public class DzikirPagi extends AppCompatActivity {

    private RecyclerView rvData;
    private ArrayList<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_pagi);

        getSupportActionBar().setTitle("Dzikir Pagi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2CA8B4"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        rvData = findViewById(R.id.rvData);
        rvData.setHasFixedSize(true);

        list.addAll(ItemDataDhikirPagi.getListData());
        showRecycleList();
    }
    private void showRecycleList() {
        rvData.setLayoutManager(new LinearLayoutManager(this));
        ListAdapterDataDhikirPagi listAdapterData = new ListAdapterDataDhikirPagi(list);
        rvData.setAdapter(listAdapterData);
    }

}