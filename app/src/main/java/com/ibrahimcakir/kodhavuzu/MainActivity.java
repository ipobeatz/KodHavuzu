package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kodhavuzu.Adapter.QuizListAdapter;
import com.ibrahimcakir.kodhavuzu.Fragments.ConfirmStartPopup;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList adapterArrayList = new ArrayList<Model>();
    private ActivityMainBinding binding;
    private Button btnShowDialog;
    public CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        cardView = (CardView) findViewById(R.id.cardView2);
        showDialog();


        Model degiskenler = new Model("buraya degiskenler girilecek", R.drawable.mojito);
        Model patates = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model hacıbakkal = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model aha = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model one = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model oa = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model onea = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model oneb = new Model("buraya degiskenler yazılacak", R.drawable.mojito);
        Model oneba = new Model("buraya degiskenler yazılacak", R.drawable.mojito);

        adapterArrayList.add(degiskenler);
        adapterArrayList.add(patates);
        adapterArrayList.add(hacıbakkal);
        adapterArrayList.add(aha);
        adapterArrayList.add(one);
        adapterArrayList.add(oa);
        adapterArrayList.add(onea);
        adapterArrayList.add(oneb);
        adapterArrayList.add(oneba);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuizListAdapter quizListAdapter = new QuizListAdapter(adapterArrayList);
        binding.recyclerView.setAdapter(quizListAdapter);
        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 1);
        binding.recyclerView.setLayoutManager(mLayoutManager);


        //setContentView(R.layout.single_quiz_card_layout);
/*
        cardView.findViewById(R.id.cardView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new ConfirmStartPopup();
                dialogFragment.show(getSupportFragmentManager(), "MyFragment");
            }
        });
*/
    }

    void showDialog() {

        ConfirmStartPopup newFragment = new ConfirmStartPopup();
        newFragment.show(this.getSupportFragmentManager(), "dialog");


    }

    public void doPositiveClick() {

        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }


}
