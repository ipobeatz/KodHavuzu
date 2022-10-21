package com.ibrahimcakir.kodhavuzu;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibrahimcakir.kodhavuzu.Adapter.TestDetailAdapter;
import com.ibrahimcakir.kodhavuzu.Model.Model;
import com.ibrahimcakir.kodhavuzu.databinding.FragmentTestDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class  TestDetailFragment extends Fragment {
    ArrayList<Model> adapterList = new ArrayList<>();
    Singleton singleton = Singleton.getInstance();


    public TestDetailFragment(List<Model> modelList) {
        adapterList.addAll(modelList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTestDetailBinding binding = FragmentTestDetailBinding.inflate(inflater, container, false);

        Model selectedModel = singleton.getSelectedModel();

        binding.historyTextView.setText(selectedModel.name);




        TestDetailAdapter testDetailAdapter = new TestDetailAdapter(adapterList);
        binding.recyclerFragment.setAdapter(testDetailAdapter);
        return binding.getRoot();

       // getActivity().getSupportFragmentManager().
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}