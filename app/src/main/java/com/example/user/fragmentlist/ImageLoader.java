package com.example.user.fragmentlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 *
 * Created by user on 11.03.2016.
 */
public class ImageLoader extends AsyncTask<MyTaskParams, Void, Drawable> {
    private final WeakReference<ImageView> imageViewReference;

    public ImageLoader(ImageView imageView) {
        imageViewReference = new WeakReference<>(imageView);
    }

    @Override
    protected Drawable doInBackground(MyTaskParams... params) {
        Context context = params[0].context;
        boolean toResize = params[0].resize;
        String imageName = params[0].imageName;
        return loadImageFromAssets(context,toResize,imageName);
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        if (drawable != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }
    private Drawable loadImageFromAssets(Context context,boolean resize,String imageName){
        Drawable myDrawable = null;
        try{
            InputStream in = context.getAssets().open(imageName);
            myDrawable = Drawable.createFromStream(in, null);
            if(resize){
                myDrawable = resize(context,myDrawable);}
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return myDrawable;
    }
    private Drawable resize(Context context, Drawable image) {
        Bitmap bitmapToResize = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmapToResize, 50, 50, false);
        return new BitmapDrawable(context.getResources(), bitmapResized);
    }
}
