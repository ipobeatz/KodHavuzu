package com.ibrahimcakir.kodhavuzu.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kodhavuzu.DetailsActivity;
import com.ibrahimcakir.kodhavuzu.Model;
import com.ibrahimcakir.kodhavuzu.Singleton;
import com.ibrahimcakir.kodhavuzu.databinding.SingleQuizCardLayoutBinding;
import com.ibrahimcakir.kodhavuzu.databinding.TripleQuizCardLayoutBinding;

import java.util.ArrayList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.RecyclerHolder> {
    ArrayList<Model> AdapterArrayList;
    final Integer singleItemViewType = 1000;
    final Integer doubleItemViewType = 1001;
    final Integer tripleItemViewType = 1002;

    public QuizListAdapter(ArrayList<Model> AdapterArrayList) {
        this.AdapterArrayList = AdapterArrayList;
    }
    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == singleItemViewType) {
            SingleQuizCardLayoutBinding recyclerRowBinding = SingleQuizCardLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new RecyclerHolder(recyclerRowBinding);
        }
        else {
            TripleQuizCardLayoutBinding recyclerRowBinding = TripleQuizCardLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new RecyclerHolder(recyclerRowBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        if (holder.getItemViewType() == singleItemViewType) {
            holder.singleBinding.recyclerViewTextView.setText(AdapterArrayList.get(position).name);
            holder.singleBinding.imageView.setImageResource(AdapterArrayList.get(position).image);


            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            });
        }
        else {
            holder.tripleBinding.recyclerViewTextView2.setText(AdapterArrayList.get(position).name);
            holder.tripleBinding.imageView.setImageResource(AdapterArrayList.get(position).image);


            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return AdapterArrayList.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        private SingleQuizCardLayoutBinding singleBinding;
        private TripleQuizCardLayoutBinding tripleBinding;

        public RecyclerHolder(SingleQuizCardLayoutBinding binding) {
            super(binding.getRoot());
            this.singleBinding = binding;
        }

        public RecyclerHolder(TripleQuizCardLayoutBinding binding) {
            super(binding.getRoot());
            this.tripleBinding = binding;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 2) {
            return singleItemViewType;
        }
        else if (position == 1) {
            return tripleItemViewType;
        }
        return tripleItemViewType;
    }
}
