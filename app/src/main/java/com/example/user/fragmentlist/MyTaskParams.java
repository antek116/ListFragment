package com.example.user.fragmentlist;

import android.content.Context;

public class MyTaskParams {
    Context context;
    boolean resize;
    String imageName;

    MyTaskParams(Context context, boolean resize,String imageName) {
        this.context = context;
        this.resize = resize;
        this.imageName = imageName;
    }
}