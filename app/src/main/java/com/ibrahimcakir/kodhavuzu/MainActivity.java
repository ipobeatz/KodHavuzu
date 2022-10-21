package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kodhavuzu.Adapter.QuizListAdapter;
import com.ibrahimcakir.kodhavuzu.Adapter.TestDetailAdapter;
import com.ibrahimcakir.kodhavuzu.Model.Model;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public CardView cardView;
    public Button recyclerButton;
    ArrayList adapterArrayList = new ArrayList<>();
    ArrayList detailArrayList = new ArrayList<>();
  //  ArrayList friends = new ArrayList<>();
    FragmentManager manager;

    private ActivityMainBinding binding;
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        manager = getSupportFragmentManager();


        findViewById(R.id.singleImageView);


        // List<Integer> list1 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            List<String> adapterList = Arrays.asList("metodlar","operatörler","diziler","koşullar");
            List<Integer> adapterDrawableList = Arrays.asList(R.drawable.ymetodlar,
                    R.drawable.kirmizi,
                    R.drawable.kkosullar,
                    R.drawable.mmetod,
                    R.drawable.moperator,
                    R.drawable.sdiziler);

      //  ArrayList<List> list = new ArrayList<List>(adapterArrayList);

        Model Veritipleri = new Model("Veri tipleri", R.drawable.kirmizi,adapterList,adapterDrawableList);
        Model Operatörler = new Model("Operatörler", R.drawable.yesil,adapterList,adapterDrawableList);
        Model Sınıflar = new Model("koşullar", R.drawable.kkosullar,adapterList,adapterDrawableList);
        Model Koşullar = new Model("Koşullar", R.drawable.mojito,adapterList,adapterDrawableList);
        Model Diziler = new Model("Diziler", R.drawable.sdiziler,adapterList,adapterDrawableList);
        Model Methotlar = new Model("Methotlar", R.drawable.mojito,adapterList,adapterDrawableList);

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




        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestDetailAdapter testDetailAdapter = new TestDetailAdapter(detailArrayList);
        binding.recyclerView.setAdapter(quizListAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager((this), 1);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

}



