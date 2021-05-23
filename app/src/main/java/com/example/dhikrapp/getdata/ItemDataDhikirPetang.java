package com.example.dhikrapp.getdata;

import com.example.dhikrapp.model.Data;
import com.example.dhikrapp.R;

import java.util.ArrayList;

public class ItemDataDhikirPetang {
    public static int photo[] = {
            R.drawable.dhikirpetang_1,
            R.drawable.dhikirpetang_2,
            R.drawable.dhikirpetang_3,
            R.drawable.dhikirpetang_4,
            R.drawable.dhikirpetang_5,
            R.drawable.dhikirpetang_6,
            R.drawable.dhikirpetang_7,
            R.drawable.dhikirpetang_8,
            R.drawable.dhikirpetang_9,
            R.drawable.dhikirpetang_10,
            R.drawable.dhikirpetang_11,
            R.drawable.dhikirpetang_12,
            R.drawable.dhikirpetang_13,
            R.drawable.dhikirpetang_14,
            R.drawable.dhikirpetang_15,
            R.drawable.dhikirpetang_16,
            R.drawable.dhikirpetang_17
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
