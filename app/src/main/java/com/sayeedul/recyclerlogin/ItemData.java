package com.sayeedul.recyclerlogin;

import android.support.v7.app.AppCompatActivity;

public class ItemData {

    private int image;
    private String title,value;

    public ItemData(int image, String title, String value) {
        this.image = image;
        this.title = title;
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
