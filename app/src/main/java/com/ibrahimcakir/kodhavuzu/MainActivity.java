package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kodhavuzu.Adapter.QuizListAdapter;
import com.ibrahimcakir.kodhavuzu.Model.Model;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public CardView cardView;
    public Button recyclerButton;
    ArrayList adapterArrayList = new ArrayList<>();
  //  ArrayList friends = new ArrayList<>();

    private ActivityMainBinding binding;
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        findViewById(R.id.singleImageView);


      //  String[] adapterList = {"asdfa","sfgdfh","erydgh"};

      //  ArrayList<List> list = new ArrayList<List>(adapterArrayList);

        Model Veritipleri = new Model("Veri tipleri", R.drawable.kirmizi);
        Model Operatörler = new Model("Operatörler", R.drawable.yesil);
        Model Sınıflar = new Model("Sınıflar", R.drawable.mojito);

        Model Koşullar = new Model("Koşullar", R.drawable.mojito);
        Model Diziler = new Model("Diziler", R.drawable.mojito);
        Model Methotlar = new Model("Methotlar", R.drawable.mojito);

        ArrayList sınıflar = new ArrayList(adapterArrayList);


        //friends = new ArrayList<String>(Arrays.asList(adapterList));

        adapterArrayList.add(Veritipleri);
        adapterArrayList.add(Operatörler);
        adapterArrayList.add(Sınıflar);

        adapterArrayList.add(Koşullar);
        adapterArrayList.add(Diziler);
        adapterArrayList.add(Methotlar);
      //  friends.add(adapterList);



        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuizListAdapter quizListAdapter = new QuizListAdapter(adapterArrayList);
        binding.recyclerView.setAdapter(quizListAdapter);
        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 1);
        binding.recyclerView.setLayoutManager(mLayoutManager);


    }

}



