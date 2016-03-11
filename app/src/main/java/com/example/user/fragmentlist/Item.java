package com.example.user.fragmentlist;

import android.graphics.drawable.Drawable;

/**
 *
 *  Created by user on 10.03.2016.
 */
public class Item {
    private String header;
    private int imageId;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setImage(int image) {
        this.imageId = image;
    }

    public String getHeader() {

        return header;
    }

    public int getImageId() {
        return imageId;
    }

    public Item(int image, String header) {
        this.imageId = image;
        this.header = header;
    }
}
