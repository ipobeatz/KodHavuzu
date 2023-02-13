package com.ibrahimcakir.kodhavuzu.Model;

import java.io.Serializable;
import java.util.List;

public class MainModel implements Serializable {
    public String name;
    public int image;
    public List<String> itemsNameList;
    public List<Integer> itemsImageList;
    public List items;




    public MainModel(String name, int image, List<String> itemsNameList, List<Integer> itemsImageList,List items) {
        this.name = name;
        this.image = image;
        this.itemsNameList = itemsNameList;
        this.itemsImageList = itemsImageList;
        this.items=items;

    }
}
