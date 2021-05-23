package com.example.dhikrapp.aktivitas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhikrapp.R;
import com.example.dhikrapp.model.DataJournal;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Detail extends AppCompatActivity implements View.OnClickListener {

    private EditText etDate, etAyat, etSurah, etDeskripsi;
    Button btnSave, btnHapus;

    String ayat, tanggal, surah, deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail Jurnal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2CA8B4"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        etAyat = findViewById(R.id.etAyatDetail);
        etDate = findViewById(R.id.etDateDetail);
        etSurah = findViewById(R.id.etSurahDetail);
        etDeskripsi = findViewById(R.id.etDeskripsiDetail);

        btnSave = findViewById(R.id.btnSaveDetail);
        btnHapus = findViewById(R.id.btnHapusDetail);

        DataJournal dataJournal = getIntent().getParcelableExtra("data");

        tanggal = dataJournal.getTanggal();
        ayat = dataJournal.getAyat();
        surah = dataJournal.getNama_surah();
        deskripsi = dataJournal.getDeskripsi();

        etAyat.setText(ayat);
        etDate.setText(tanggal);
        etSurah.setText(surah);
        etDeskripsi.setText(deskripsi);


        btnHapus.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSaveDetail:
                String tempAyat = etAyat.getText().toString();
                String tempSurah = etSurah.getText().toString();
                String tempTanggal = etDate.getText().toString();
                String tempDeskripsi = etDeskripsi.getText().toString();

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Data");

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot data : snapshot.getChildren()){

                            String key = data.getKey();
                            String hasilAyat = data.child("ayat").getValue().toString();
                            String hasilTanggal = data.child("tanggal").getValue().toString();
                            String hasilSurah = data.child("nama_surah").getValue().toString();
                            String hasilDeskripsi = data.child("deskripsi").getValue().toString();

                            if (hasilAyat.equals(ayat) && hasilSurah.equals(surah) && hasilTanggal.equals(tanggal) && hasilDeskripsi.equals(deskripsi)){
                                Map<String, String> map = new HashMap<>();
                                map.put("ayat", tempAyat);
                                map.put("nama_surah", tempSurah);
                                map.put("tanggal", tempTanggal);
                                map.put("deskripsi", tempDeskripsi);

                                databaseReference.child(key).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(Detail.this, "succes edit", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                finish();
                break;
            case R.id.btnHapusDetail:
                DatabaseReference dataRef=  FirebaseDatabase.getInstance().getReference().child("Data");

                dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot data : snapshot.getChildren()){
                            Log.d("detail", data.getKey());
                            String tempAyat = data.child("ayat").getValue().toString();
                            String tempSurah = data.child("nama_surah").getValue().toString();
                            String tempTanggal = data.child("tanggal").getValue().toString();
                            String tempDeskripsi = data.child("deskripsi").getValue().toString();

                            String key = data.getKey();
                            if (tempAyat.equals(ayat) && tempSurah.equals(surah) && tempTanggal.equals(tanggal) && tempDeskripsi.equals(deskripsi)){
                                dataRef.child(key).removeValue();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                finish();
                break;
        }
    }
}