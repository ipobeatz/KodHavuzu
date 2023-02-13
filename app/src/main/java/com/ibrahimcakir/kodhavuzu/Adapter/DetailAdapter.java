package com.ibrahimcakir.kodhavuzu.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimcakir.kodhavuzu.DetailsActivity;
import com.ibrahimcakir.kodhavuzu.MainActivity;
import com.ibrahimcakir.kodhavuzu.Model.MainModel;
import com.ibrahimcakir.kodhavuzu.Singleton;
import com.ibrahimcakir.kodhavuzu.TestScreen;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityContentTestScreenBinding;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityLoginScreenBinding;
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


        holder.itemView.setOnClickListener(view -> {

            holder.binding.recyclerViewTextView.setText(AdapterArrayList.get(position).name);


            Intent intent = new Intent(holder.itemView.getContext(), TestScreen.class);
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
