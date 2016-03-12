package com.example.user.fragmentlist;



/**
 *
 *  Created by user on 10.03.2016.
 */
public class Item {
    private String header;
    private String imageId;

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
