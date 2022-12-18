package com.ibrahimcakir.kodhavuzu.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kodhavuzu.DetailsActivity;
import com.ibrahimcakir.kodhavuzu.Model.MainModel;
import com.ibrahimcakir.kodhavuzu.Singleton;
import com.ibrahimcakir.kodhavuzu.databinding.FragmentTestDetailBinding;
import com.ibrahimcakir.kodhavuzu.databinding.TestDetailRowBinding;

import java.util.ArrayList;

//maindetayolacak bura
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {
    ArrayList<MainModel> AdapterArrayList;

    public DetailAdapter(ArrayList<MainModel> AdapterArrayList) {
        this.AdapterArrayList = AdapterArrayList;
    }
    @NonNull
    @Override
    public DetailAdapter.DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TestDetailRowBinding testDetailRowBinding = TestDetailRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailHolder(testDetailRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.DetailHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(AdapterArrayList.get(position).name);
        holder.binding.imageView3.setImageResource(AdapterArrayList.get(position).image);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
            Singleton singleton = Singleton.getInstance();
            singleton.setChosenModel(AdapterArrayList.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return AdapterArrayList.size();


    }

    public class DetailHolder extends RecyclerView.ViewHolder {
        private final TestDetailRowBinding binding;

        public DetailHolder (TestDetailRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
