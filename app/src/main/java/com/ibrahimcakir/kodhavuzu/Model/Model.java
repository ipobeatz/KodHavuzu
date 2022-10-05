package com.ibrahimcakir.kodhavuzu.Model;

import java.io.Serializable;
import java.util.List;

public class Model implements Serializable {
    public String name;
    public int image;



    public Model(String name,int image) {
        this.name = name;
        this.image = image;
    }
}
