package com.ibrahimcakir.kodhavuzu;

public class Singleton {
    private static Singleton singleton;
    private Model selectedModel;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Model getSelectedModel() {
        return selectedModel;
    }

    public void setChosenModel(Model selectedModel) {
        this.selectedModel = selectedModel;
    }

}

