package com.example.findschedule;

import java.util.ArrayList;

public class DataItemPopular {
    private String linkImage;

    public DataItemPopular(){}

    public DataItemPopular(String linkimage){
        this.linkImage = linkimage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkImage(){
        return linkImage;
    }

    public void addItem(String link, ArrayList<DataItemPopular> listPopular){
        listPopular.add(new DataItemPopular(link));
    }
}
