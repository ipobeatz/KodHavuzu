package com.ibrahimcakir.kodhavuzu.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kodhavuzu.DetailsActivity;
import com.ibrahimcakir.kodhavuzu.Model.MainModel;
import com.ibrahimcakir.kodhavuzu.Singleton;
import com.ibrahimcakir.kodhavuzu.databinding.TestDetailRowBinding;

import java.util.ArrayList;

    public class TestDetailAdapter extends RecyclerView.Adapter<TestDetailAdapter.TestHolder> {
        ArrayList<MainModel> DetailArrayList;

        public TestDetailAdapter(ArrayList<MainModel> DetailArrayList) {
            this.DetailArrayList = DetailArrayList;
        }

        @NonNull
        @Override
        public TestDetailAdapter.TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TestDetailRowBinding testDetailRowBinding = TestDetailRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new TestHolder(testDetailRowBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {

            holder.binding.recyclerViewTextView.setText(DetailArrayList.get(position).name);


//            holder.itemView.setOnClickListener(view -> {
//                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
//                Singleton singleton = Singleton.getInstance();
//                singleton.setChosenModel(DetailArrayList.get(position));
//                holder.itemView.getContext().startActivity(intent);
//            });


        }

        @Override
        public int getItemCount() {
            return DetailArrayList.size();
        }

        public class TestHolder extends RecyclerView.ViewHolder {
            private final TestDetailRowBinding binding;


            public TestHolder(TestDetailRowBinding binding) {
                super(binding.getRoot());
                this.binding = binding;

            }
        }
    }
