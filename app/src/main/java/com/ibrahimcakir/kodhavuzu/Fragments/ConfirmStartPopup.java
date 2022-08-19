package com.ibrahimcakir.kodhavuzu.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.ibrahimcakir.kodhavuzu.MainActivity;
import com.ibrahimcakir.kodhavuzu.R;

public class ConfirmStartPopup extends DialogFragment {


    public static ConfirmStartPopup newInstance() {

        return new ConfirmStartPopup();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.confirm_start_popup, container, false);


        v.findViewById(R.id.btnHayir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).doNegativeClick();
            }
        });
        v.findViewById(R.id.btnEvet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).doPositiveClick();

            }
        });
        return v;
    }

}


