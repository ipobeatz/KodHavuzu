package com.ibrahimcakir.kodhavuzu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ibrahimcakir.kodhavuzu.Adapter.CustomViewPager;
import com.ibrahimcakir.kodhavuzu.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {
    private CustomViewPager mAdapter;
    private ActivityLoginScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);





    }


}