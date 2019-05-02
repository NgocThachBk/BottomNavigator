package com.example.findschedule;

import java.io.Serializable;
import java.util.ArrayList;

public class Data2 implements Serializable {
    private ArrayList<Data1> PlaceItems;

    public Data2(){}

    public Data2(ArrayList<Data1> Items){
        PlaceItems = Items;
    }

    public void setPlaceItems(ArrayList<Data1> placeItems) {
        this.PlaceItems = placeItems;
    }

    public ArrayList<Data1> getPlaceItems(){return PlaceItems;}

    public static void addItem(ArrayList<Data1> item,ArrayList<Data2> listItem){
        listItem.add(new Data2(item));
    }
}
