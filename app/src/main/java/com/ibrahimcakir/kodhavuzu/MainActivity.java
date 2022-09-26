package com.ibrahimcakir.kodhavuzu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kodhavuzu.Adapter.QuizListAdapter;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public CardView cardView;
    public Button recyclerButton;
    ArrayList adapterArrayList = new ArrayList<Model>();
    private ActivityMainBinding binding;
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        cardView = findViewById(R.id.singleCardView);


        Model degiskenler = new Model("değişkenler", R.drawable.inter);
        Model Veritipleri = new Model("Veri tipleri", R.drawable.mojito);
        Model Operatörler = new Model("Operatörler", R.drawable.mojito);
        Model Sınıflar = new Model("Sınıflar", R.drawable.mojito);
        Model Mantıksalveritipleri = new Model("Mantıksal veri tipleri", R.drawable.mojito);
        Model Koşullar = new Model("Koşullar", R.drawable.mojito);
        Model Diziler = new Model("Diziler", R.drawable.mojito);
        Model Methotlar = new Model("Methotlar", R.drawable.mojito);


        adapterArrayList.add(degiskenler);
        adapterArrayList.add(Veritipleri);
        adapterArrayList.add(Operatörler);
        adapterArrayList.add(Sınıflar);
        adapterArrayList.add(Mantıksalveritipleri);
        adapterArrayList.add(Koşullar);
        adapterArrayList.add(Diziler);
        adapterArrayList.add(Methotlar);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuizListAdapter quizListAdapter = new QuizListAdapter(adapterArrayList);
        binding.recyclerView.setAdapter(quizListAdapter);
        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 1);
        binding.recyclerView.setLayoutManager(mLayoutManager);


    }

}



