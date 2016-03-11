package com.example.user.fragmentlist;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 *  Created by user on 10.03.2016.
 */
public class DescriptionFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    int imageId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Object arg = getArguments().get("imgId");
        imageId = Integer.parseInt(getArguments().get("imgId").toString());
        ImageView view = (ImageView) getView().findViewById(R.id.descriptionImage);
        view.setImageDrawable(getResources().getDrawable(R.drawable.ananas));

        int x = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }


        return inflater.inflate(R.layout.item_description, container, false);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

//    public void uptadeImageDescription(int position, Drawable image) {
//        ImageView descriptionImage = (ImageView) getActivity().findViewById(R.id.descriptionImageView);
//        descriptionImage.setImageDrawable(image);
//        mCurrentPosition = position;
//    }

}
