package com.example.findschedule;

import java.io.Serializable;

public class Data1 implements Serializable {
    private String name;
    private String Image;
    public Data1(){}

    public Data1(String name, String image){
        this.name = name;
        this.Image = image;
    }

    public void setname(String name){
        this.name = name;
    }

    public void setImage(String image){
        this.Image = image;
    }

    public String getname(){return  name;}
    public String getImage(){return Image;}
}
