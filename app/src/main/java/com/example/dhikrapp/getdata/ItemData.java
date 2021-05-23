package com.example.dhikrapp.getdata;

import com.example.dhikrapp.model.Data;
import com.example.dhikrapp.R;

import java.util.ArrayList;

public class ItemData {

    public static int photo[] = {
            R.drawable.dhikirsetelahsholat_1,
            R.drawable.dhikirsetelahsholat_2,
            R.drawable.dhikirsetelahsholat_3,
            R.drawable.dhikirsetelahsholat_4,
            R.drawable.dhikirsetelahsholat_5,
            R.drawable.dhikirsetelahsholat_6,
            R.drawable.dhikirsetelahsholat_7,
            R.drawable.dhikirsetelahsholat_8,
            R.drawable.dhikirsetelahsholat_9,
            R.drawable.dhikirsetelahsholat_10,
            R.drawable.dhikirsetelahsholat_11,
            R.drawable.dhikirsetelahsholat_12,
            R.drawable.dhikirsetelahsholat_13,
            R.drawable.dhikirsetelahsholat_14,
            R.drawable.dhikirsetelahsholat_15
    };

    public static ArrayList<Data> getListData(){
        ArrayList<Data> list = new ArrayList<>();
        for (int position = 0; position < photo.length; position++){
            Data data = new Data();
            data.setPhoto(photo[position]);
            list.add(data);
        }
        return list;
    };
}
