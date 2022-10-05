package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ibrahimcakir.kodhavuzu.Adapter.CustomViewPager;
import com.ibrahimcakir.kodhavuzu.Model.Model;
import com.ibrahimcakir.kodhavuzu.databinding.DetailsActivityBinding;

public class DetailsActivity extends AppCompatActivity {

    private DetailsActivityBinding binding;
    Singleton singleton = Singleton.getInstance();
    private CustomViewPager mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailsActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        example();

        Model selectedModel = singleton.getSelectedModel();

        binding.textView.setText(selectedModel.name);
        binding.imageView2.setImageResource(selectedModel.image);


    }

    public void example(){

        mAdapter = new CustomViewPager(getSupportFragmentManager(),getApplicationContext());




    }


}





