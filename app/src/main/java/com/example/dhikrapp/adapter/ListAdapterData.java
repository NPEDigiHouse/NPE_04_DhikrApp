package com.example.dhikrapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dhikrapp.model.Data;
import com.example.dhikrapp.R;

import java.util.ArrayList;

public class ListAdapterData extends RecyclerView.Adapter<ListAdapterData.ListViewHolder> {
    private ArrayList<Data> listData;
    private OnItemClickCallback onItemClickCallback;

    public ListAdapterData(ArrayList<Data> list){
        this.listData = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListAdapterData.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_home,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterData.ListViewHolder holder, int position) {
        final Data data = listData.get(position);
        Glide.with(holder.itemView.getContext()).load(data.getPhoto()).apply(new RequestOptions().override(55, 55));
        holder.imgPhoto.setImageResource(data.getPhoto());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.photo);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Data data);
    }
}
