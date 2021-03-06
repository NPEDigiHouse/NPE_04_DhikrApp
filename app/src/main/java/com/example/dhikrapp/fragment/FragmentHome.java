package com.example.dhikrapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dhikrapp.aktivitas.DzikirPagi;
import com.example.dhikrapp.aktivitas.DzikirPetang;
import com.example.dhikrapp.aktivitas.DzikirSetelahSholat;
import com.example.dhikrapp.R;
import com.example.dhikrapp.aktivitas.SatuHariSatuAyat;

public class FragmentHome extends Fragment implements View.OnClickListener {

    ImageView imgDzikirPagi, imgDzikirPetang, imgDzikirSetelahSholat, imgSatuhariSatuAyat;

    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        imgDzikirPagi = view.findViewById(R.id.dzikirPagi);
        imgDzikirPetang = view.findViewById(R.id.dzikirPetang);
        imgDzikirSetelahSholat = view.findViewById(R.id.dzikirSetelahSholat);
        imgSatuhariSatuAyat = view.findViewById(R.id.satuHariSatuAyat);

        imgDzikirPagi.setOnClickListener(this);
        imgDzikirPetang.setOnClickListener(this);
        imgDzikirSetelahSholat.setOnClickListener(this);
        imgSatuhariSatuAyat.setOnClickListener(this);


        Glide.with(getContext()).load(R.drawable.dzhikir_setelah_sholat).into(imgDzikirSetelahSholat);
        Glide.with(getContext()).load(R.drawable.dzikir_pagi).into(imgDzikirPagi);
        Glide.with(getContext()).load(R.drawable.dzikir_petang).into(imgDzikirPetang);
        Glide.with(getContext()).load(R.drawable.satu_hari_satu_ayat).into(imgSatuhariSatuAyat);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.satuHariSatuAyat:
                Intent toSatuHariSatuAyat = new Intent(getActivity(), SatuHariSatuAyat.class);
                startActivity(toSatuHariSatuAyat);
                break;
            case R.id.dzikirSetelahSholat:
                Intent toDzhikirSetelahSholat = new Intent(getActivity(), DzikirSetelahSholat.class);
                startActivity(toDzhikirSetelahSholat);
                break;
            case  R.id.dzikirPetang:
                Intent toDzikirPetang = new Intent(getActivity(), DzikirPetang.class);
                startActivity(toDzikirPetang);
                break;
            case R.id.dzikirPagi:
                Intent toDzikirPagi = new Intent(getActivity(), DzikirPagi.class);
                startActivity(toDzikirPagi);
                break;
        }
    }
}
