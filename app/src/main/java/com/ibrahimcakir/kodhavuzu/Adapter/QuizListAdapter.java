package com.ibrahimcakir.kodhavuzu.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kodhavuzu.DetailsActivity;
import com.ibrahimcakir.kodhavuzu.Model.Model;
import com.ibrahimcakir.kodhavuzu.R;
import com.ibrahimcakir.kodhavuzu.Singleton;
import com.ibrahimcakir.kodhavuzu.TestDetailFragment;
import com.ibrahimcakir.kodhavuzu.TestScreen;
import com.ibrahimcakir.kodhavuzu.databinding.DoubleQuizCardLayoutBinding;
import com.ibrahimcakir.kodhavuzu.databinding.SingleQuizCardLayoutBinding;
import com.ibrahimcakir.kodhavuzu.databinding.TestDetailRowBinding;
import com.ibrahimcakir.kodhavuzu.databinding.TripleQuizCardLayoutBinding;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.RecyclerHolder> {



    ArrayList<Model> AdapterArrayList;
    ArrayList adapterArrayList;
    final Integer singleItemViewType = 1000;
    final Integer doubleItemViewType = 1001;
    final Integer tripleItemViewType = 1002;
    FragmentManager manager;




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
        else if (viewType == doubleItemViewType){
            DoubleQuizCardLayoutBinding recyclerRowBinding = DoubleQuizCardLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new RecyclerHolder(recyclerRowBinding);

        }
        else if (viewType == tripleItemViewType){
            TripleQuizCardLayoutBinding recyclerRowBinding = TripleQuizCardLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new RecyclerHolder(recyclerRowBinding);
        }
        return null;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        if (holder.getItemViewType() == singleItemViewType) {

            holder.singleBinding.singleRecyclerViewTextView.setText(AdapterArrayList.get(position).name);
            holder.singleBinding.singleImageView.setImageResource(AdapterArrayList.get(position).image);
            holder.singleBinding.singleImageView.setOnClickListener(view -> {

                showAlertDialog(holder.itemView.getContext());
            });
        }


        else if (holder.getItemViewType() == doubleItemViewType) {
            holder.doubleBinding.doubleRecyclerViewTextView.setText(AdapterArrayList.get(position).itemsNameList.get(0));
            holder.doubleBinding.doubleRecyclerViewTextView2.setText(AdapterArrayList.get(position).itemsNameList.get(1));

            holder.doubleBinding.doubleImageView.setImageResource(AdapterArrayList.get(position).itemsImageList.get(0));
            holder.doubleBinding.doubleImageView2.setImageResource(AdapterArrayList.get(position).itemsImageList.get(1));

            holder.doubleBinding.doubleImageView.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(),  TestDetailFragment.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            });
//bura eklendi

            holder.doubleBinding.doubleImageView2.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            });
        }
        else if (holder.getItemViewType() == tripleItemViewType) {
            holder.tripleBinding.tripleRecyclerViewTextView.setText(AdapterArrayList.get(position).itemsNameList.get(2));
            holder.tripleBinding.tripleImageView.setImageResource(AdapterArrayList.get(position).itemsImageList.get(3));

            holder.tripleBinding.tripleRecyclerViewTextView2.setText(AdapterArrayList.get(position).itemsNameList.get(1));
            holder.tripleBinding.tripleImageView2.setImageResource(AdapterArrayList.get(position).itemsImageList.get(4));

            holder.tripleBinding.tripleRecyclerViewTextView3.setText(AdapterArrayList.get(position).itemsNameList.get(0));
            holder.tripleBinding.tripleImageView3.setImageResource(AdapterArrayList.get(position).itemsImageList.get(5));

            holder.tripleBinding.tripleImageView.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            });


            holder.tripleBinding.tripleImageView.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), TestScreen.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            });

            holder.tripleBinding.tripleImageView2.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenModel(AdapterArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            });

            holder.tripleBinding.tripleImageView3.setOnClickListener(view -> {
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
        private DoubleQuizCardLayoutBinding doubleBinding;
        private TripleQuizCardLayoutBinding tripleBinding;

        public RecyclerHolder(SingleQuizCardLayoutBinding binding) {
            super(binding.getRoot());
            this.singleBinding = binding;
        }

        public RecyclerHolder(DoubleQuizCardLayoutBinding binding) {
            super(binding.getRoot());
            this.doubleBinding = binding;
        }

        public RecyclerHolder(TripleQuizCardLayoutBinding binding) {
            super(binding.getRoot());
            this.tripleBinding = binding;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 2 || position == 4) {
            return singleItemViewType;
        }
        else if (position == 1 ) {
            return doubleItemViewType;
        }
        else if (position == 3 ) {
            return tripleItemViewType;
        }
        return tripleItemViewType;

    }

    private void showAlertDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        new AlertDialog.Builder(context)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, TestScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }
                })

                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

}

