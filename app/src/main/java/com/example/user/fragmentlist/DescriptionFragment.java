package com.example.user.fragmentlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 *
 *  Created by user on 10.03.2016.
 */
public class DescriptionFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    String header;
    String imageName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        header = getArguments().getString("headerText");
        imageName = getArguments().getString("imageName");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_description,container,false);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(header);
        ImageView imageView = (ImageView) view.findViewById(R.id.descriptionImage);
        ImageLoader loader = new ImageLoader(imageView);
        MyTaskParams parameters = new MyTaskParams(getContext(),false,imageName);
        loader.execute(parameters);
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }


        return view;
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
