package com.example.dhikrapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhikrapp.R;
import com.example.dhikrapp.adapter.ListAdapterDataJournal;
import com.example.dhikrapp.model.DataJournal;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BotomSheetDialog extends BottomSheetDialogFragment {

//    private BottomSheetListener mlistener;
    ListAdapterDataJournal listAdapterDataJournal;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    ArrayList<DataJournal> listItem = new ArrayList<>();
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_bottom_sheet, container, false);

        recyclerView = v.findViewById(R.id.rvData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        FirebaseRecyclerOptions<DataJournal> options = new FirebaseRecyclerOptions.Builder<DataJournal>().setQuery(FirebaseDatabase.getInstance().getReference().child("Data"), DataJournal.class).build();
        listAdapterDataJournal = new ListAdapterDataJournal(options);
        recyclerView.setAdapter(listAdapterDataJournal);

//        listAdapterDataJournal.setOnItemClickCallBack(new ListAdapterDataJournal.OnItemClickCallBack() {
//            @Override
//            public void onItemClicked(DataJournal data) {
////                Intent i = new Intent(getContext(), Detail.class);
////                i.putExtra("rv_item", data);
////                startActivity(i);
//            }
//        });

//        btnToUd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        return v;
    }

//    public interface BottomSheetListener{
//        void onButtonClicked(String text);
//    }


    @Override
    public void onStart() {
        super.onStart();
        listAdapterDataJournal.startListening();
    }
}
