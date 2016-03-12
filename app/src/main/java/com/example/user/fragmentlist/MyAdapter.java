package com.example.user.fragmentlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final ListItemFragment.OnHeadlineSelectedListener mListener;
    private final Context context;


    public MyAdapter(Context context, List<Item> items, ListItemFragment.OnHeadlineSelectedListener listener) {
        this.mValues = items;
        this.mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        ImageLoader oldTask =(ImageLoader) holder.mImage.getTag();
        ImageLoader loader = new ImageLoader(holder.mImage);
        MyTaskParams parameters = new MyTaskParams(context, true, mValues.get(position).getImageId());

        if(oldTask == null){
            loader.execute(parameters);
            holder.mImage.setTag(loader);
        }
        else{
            oldTask.cancel(true);
            loader.execute(parameters);
            holder.mImage.setTag(loader);
        }
        holder.mHeaderText.setText(mValues.get(position).getHeader());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onHeaderSelected(position, mValues);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mHeaderText;
        public final ImageView mImage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mHeaderText = (TextView) view.findViewById(R.id.header_title);
            mImage = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mHeaderText.getText() + "'";
        }
    }
}