package com.example.dhikrapp.aktivitas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhikrapp.R;
import com.example.dhikrapp.fragment.BotomSheetDialog;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SatuHariSatuAyat extends AppCompatActivity implements View.OnClickListener{

    EditText etDate, etSurah, etAyat, etDeskripsi;
    Button btnSave, btnJournal;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satu_hari_satu_ayat);

        getSupportActionBar().setTitle("Satu Hari Satu Ayat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2CA8B4"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        etDate = findViewById(R.id.etDate);
        etSurah = findViewById(R.id.etNamaSurah);
        etAyat = findViewById(R.id.etAyat);
        etDeskripsi = findViewById(R.id.etDeskripsi);

        btnSave = findViewById(R.id.btnSave);
        btnJournal = findViewById(R.id.btnJournal);

        btnSave.setOnClickListener(this);
        btnJournal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnJournal:
                BotomSheetDialog bottomSheetDialog = new BotomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "example");

                break;
            case R.id.btnSave:
                Map<String, Object> map = new HashMap<>();
                map.put("tanggal", etDate.getText().toString());
                map.put("nama_surah", etSurah.getText().toString());
                map.put("ayat", etAyat.getText().toString());
                map.put("deskripsi", etDeskripsi.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("Data").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(view.getContext(), "succes input data", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(view.getContext(), "failure input data", Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }

}