package com.example.dhikrapp.getdata;

import com.example.dhikrapp.model.Data;
import com.example.dhikrapp.R;

import java.util.ArrayList;

public class ItemDataDhikirPagi {

    public static int photo[] = {
            R.drawable.dhikirpagi_1,
            R.drawable.dhikirpagi_2,
            R.drawable.dikirpagi_3,
            R.drawable.dikirpagi_4,
            R.drawable.dikirpagi_5,
            R.drawable.dhikirpagi_6,
            R.drawable.dhikirpagi_7,
            R.drawable.dikirpagi_8,
            R.drawable.dhikirpagi_9,
            R.drawable.dikirpagi_10,
            R.drawable.dhikirpagi_11,
            R.drawable.dhikirpagi_12,
            R.drawable.dhikirpagi_13,
            R.drawable.dhikirpagi_14,
            R.drawable.dhikirpagi_15,
            R.drawable.dhikipagi_16,
            R.drawable.dhikirpagi_17,
            R.drawable.dhikirpagi_18,
            R.drawable.dhikirpagi_19
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
