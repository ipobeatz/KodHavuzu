package com.ibrahimcakir.kodhavuzu.Model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {
    public String name;
    public int image;
    public List<String> itemsNameList;
    public List<Integer> itemsImageList;



    public Model(String name,int image,List<String> itemsNameList,List<Integer> itemsImageList) {
        this.name = name;
        this.image = image;
        this.itemsNameList = itemsNameList;
        this.itemsImageList = itemsImageList;
    }
}
