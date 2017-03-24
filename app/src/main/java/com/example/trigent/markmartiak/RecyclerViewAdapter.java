package com.example.trigent.markmartiak;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by swarnim_d on 01-12-2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    private ArrayList<NewsModel> mDataset;

    public RecyclerViewAdapter(ArrayList<NewsModel> mDataset) {
        this.mDataset = mDataset;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCard;
        public TextView mHeading,mDate;
        public ImageView mImage;

        public ViewHolder(CardView cardView) {
            super(cardView);
            mCard = cardView;
            mImage = (ImageView) mCard.findViewById(R.id.item_image);
            mHeading = (TextView) mCard.findViewById(R.id.item_heading);
            mDate = (TextView) mCard.findViewById(R.id.item_date);

        }
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder((CardView) v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        context = holder.mCard.getContext();

        final int Pos = position;
        final NewsModel newsModel = mDataset.get(holder.getAdapterPosition());
        holder.mImage.setImageResource(newsModel.getmImage());
        holder.mHeading.setText(newsModel.getmHeading());
        holder.mDate.setText(newsModel.getmDate());

    holder.mCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            NewsDescFragment newsDescFragment = new NewsDescFragment();
            Bundle bundle = new Bundle();
            bundle.putString("heading", newsModel.getmHeading());
            bundle.putInt("position",Pos);
            bundle.putString("date",newsModel.getmDate());
            bundle.putString("desc",newsModel.getmDescription());
            newsDescFragment.setArguments(bundle);
            FragmentManager fm = ((MainActivity)context).getFragmentManager();
            FragmentTransaction fragmentTransaction =fm.beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.replace(R.id.main_activity_frame_layout,newsDescFragment).commit();
        }
    });


    }



    @Override
    public int getItemCount() {


        return mDataset.size();
    }


}
