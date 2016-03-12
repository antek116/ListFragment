package com.example.user.fragmentlist;

import android.graphics.drawable.Drawable;

/**
 *
 *  Created by user on 10.03.2016.
 */
public class Item {
    private String header;
    private String imageId;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setImage(String image) {
        this.imageId = image;
    }

    public String getHeader() {

        return header;
    }

    public String getImageId() {
        return imageId;
    }

    public Item(String image, String header) {
        this.imageId = image;
        this.header = header;
    }
}
