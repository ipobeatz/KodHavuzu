package com.ibrahimcakir.kodhavuzu;

import com.ibrahimcakir.kodhavuzu.Model.MainModel;

public class Singleton {
    private static Singleton singleton;
    private MainModel selectedMainModel;


    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public MainModel getSelectedModel() {
        return selectedMainModel;

    }

    public void setChosenModel(MainModel selectedMainModel) {
        this.selectedMainModel = selectedMainModel;
    }

}

