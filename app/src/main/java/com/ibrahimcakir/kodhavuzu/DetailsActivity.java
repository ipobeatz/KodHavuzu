package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.navigation.NavigationView;
import com.ibrahimcakir.kodhavuzu.Adapter.CustomViewPager;
import com.ibrahimcakir.kodhavuzu.Adapter.DetailAdapter;
import com.ibrahimcakir.kodhavuzu.Model.MainModel;
import com.ibrahimcakir.kodhavuzu.databinding.DetailsActivityBinding;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList adapterArrayList = new ArrayList<MainModel>();
    private DetailsActivityBinding binding;
    Singleton singleton = Singleton.getInstance();

    private CustomViewPager mAdapter;
    ArrayList detailArrayList = new ArrayList<>();
    DetailAdapter detailAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailsActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        MainModel asa = new MainModel("1.TEST",R.drawable.sdiziler,null,null,null);
        MainModel asaaa = new MainModel("2.TEST",R.drawable.sdiziler,null,null,null);
        MainModel asaasfasdf = new MainModel("3.TEST",R.drawable.sdiziler,null,null,null);

        adapterArrayList.add(asaaa);
        adapterArrayList.add(asaasfasdf);
        adapterArrayList.add(asa);




        binding.recyclername.setLayoutManager(new LinearLayoutManager(this));
         detailAdapter = new DetailAdapter(adapterArrayList);
        binding.recyclername.setAdapter(detailAdapter);
        detailAdapter.notifyDataSetChanged();

        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 1);
        binding.recyclername.setLayoutManager(mLayoutManager);







    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {

            case (R.id.nav_home):
                Toast.makeText(this, "Clicked Home", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_gallery):
                Toast.makeText(this, "Clicked Gallery", Toast.LENGTH_SHORT).show();
                break;


        }
//navigation
        return false;

    }

}





