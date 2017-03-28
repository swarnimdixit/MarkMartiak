package com.example.trigent.markmartiak;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewGroup viewGroup;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    int[] newsImageArray = {R.drawable.trump,R.drawable.globalization,R.drawable.princerogernelson,R.drawable.trump2,R.drawable.davidbowie};


    public String[] newsHeadingArray;
    public String[] newsDescArray;
    public String[] newsDateArray;
    ArrayList<NewsModel> arrayListModel = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewGroup=container;


        Resources res = getResources();
       newsHeadingArray =res.getStringArray(R.array.string_array_heading);
       newsDescArray = res.getStringArray(R.array.string_array_description);
       newsDateArray = res.getStringArray(R.array.string_array_date);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for(int i=0;i<newsHeadingArray.length;i++) {
            NewsModel newsModel = new NewsModel();
            newsModel.setmHeading(newsHeadingArray[i]);
            newsModel.setmDate(newsDateArray[i]);
            newsModel.setmDescription(newsDescArray[i]);
            newsModel.setmImage(newsImageArray[i]);
            arrayListModel.add(newsModel);
        }

        mRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);// recycler view size do not change according to the size of content
        //creating Layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //Creating and setting Adapter
        mAdapter = new RecyclerViewAdapter(arrayListModel);
        mRecyclerView.setAdapter(mAdapter);




    }
    public interface OnFragmentInteractionListener {
    }


}
