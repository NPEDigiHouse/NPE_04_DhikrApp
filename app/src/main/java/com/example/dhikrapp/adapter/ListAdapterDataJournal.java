package com.example.dhikrapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhikrapp.model.DataJournal;
import com.example.dhikrapp.aktivitas.Detail;
import com.example.dhikrapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ListAdapterDataJournal extends FirebaseRecyclerAdapter<DataJournal, ListAdapterDataJournal.ViewHolder> {


    public ListAdapterDataJournal(@NonNull FirebaseRecyclerOptions<DataJournal> options) {
        super(options);
    }

    private ListAdapterDataJournal.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListAdapterDataJournal.OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull DataJournal dataJournal) {

        viewHolder.tvAyat.setText(dataJournal.getAyat());
        viewHolder.tvNamaSurah.setText(dataJournal.getNama_surah());
        viewHolder.tvDate.setText(dataJournal.getTanggal());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(view.getContext(), Detail.class);
                o.putExtra("data", dataJournal);
                view.getContext().startActivity(o);

            }
        });

//        viewHolder.btnUD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(view.getContext(), Detail.class);
//                view.getContext().startActivity(i);
//
//            }
//        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_rv_journal, parent, false);
        return new ViewHolder(view);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvNamaSurah, tvAyat;

        ImageView btnUD;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDateData);
            tvAyat = itemView.findViewById(R.id.tvAyat);
            tvNamaSurah = itemView.findViewById(R.id.tvNamaSurah);
            btnUD =  itemView.findViewById(R.id.btnToUD);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataJournal data);
    }
}
