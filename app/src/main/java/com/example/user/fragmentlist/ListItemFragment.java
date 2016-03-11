package com.example.user.fragmentlist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Created by user on 10.03.2016.
 */
public class ListItemFragment extends Fragment {
    ArrayList<Item> exampleListItemList;

    OnHeadlineSelectedListener mCallback;

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onHeaderSelected(int position, List<Item> itemList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item_fragment_view, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allHeaders);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new MyAdapter(exampleListItemList, mCallback));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleListItemList = new ArrayList<>();
        int[] drawableId = {
                R.drawable.ananas,R.drawable.batman,R.drawable.bubble,R.drawable.droga,R.drawable.dom,
                R.drawable.superman
        };
        int size = 0;
        for (int i = 0; i < 20; ++i){
            if(size == 5){
                size = 0;
            }
            exampleListItemList.add(new Item(drawableId[size],"Jakis Title"));
            size++;
        }

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }



}
