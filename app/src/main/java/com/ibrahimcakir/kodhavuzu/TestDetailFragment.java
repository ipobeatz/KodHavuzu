package com.ibrahimcakir.kodhavuzu;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibrahimcakir.kodhavuzu.Adapter.TestDetailAdapter;
import com.ibrahimcakir.kodhavuzu.Model.MainModel;
import com.ibrahimcakir.kodhavuzu.databinding.FragmentTestDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class  TestDetailFragment extends Fragment {

    ArrayList<MainModel> adapterList = new ArrayList<>();
    Singleton singleton = Singleton.getInstance();
/*
    public TestDetailFragment(List<MainModel> mainModelList) {
        adapterList.addAll(mainModelList);
    }

 */
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding.recyclerFragment.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        binding.recyclerFragment.setHasFixedSize(true);
        binding.recyclerFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerFragment.setItemAnimator(new DefaultItemAnimator());

        FragmentAdapter fragmentAdapter = new FragmentAdapter(adapterList);
        binding.recyclerFragment.setAdapter(fragmentAdapter);

        return binding.getRoot();
    }
*/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView historyText = view.findViewById(R.id.historyTextView);
        //2- Datayı çek.
        Singleton singleton = Singleton.getInstance();
        MainModel mainmodel = singleton.getSelectedModel();
        //3- Datayı set et.
        historyText.setText(mainmodel.name);
    }

}