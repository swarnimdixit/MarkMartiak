package com.example.trigent.markmartiak;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by swarnim_d on 24-03-2017.
 */

public class NewsDescFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView newsDescFragHeading,newsDescFragDate,newsDescFragDescription;
    ImageView newDescFragImage;
    int[] newsImageArray =
            {R.drawable.trump,R.drawable.globalization,R.drawable.princerogernelson,R.drawable.trump2,R.drawable.davidbowie};


    public NewsDescFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View   view = inflater.inflate(R.layout.fragment_news_desc, container, false);

        newsDescFragHeading = (TextView) view.findViewById(R.id.news_desc_heading);
        newsDescFragDate = (TextView) view.findViewById(R.id.news_desc_date);
        newsDescFragDescription  = (TextView) view.findViewById(R.id.news_desc_description);
        newDescFragImage = (ImageView) view.findViewById(R.id.news_desc_image);



        Bundle bundle = getArguments();
        if (bundle != null) {
            int position = bundle.getInt("position");
            newsDescFragHeading.setText(bundle.getString("heading"));
            newsDescFragDate.setText(bundle.getString("date"));
            newsDescFragDescription.setText(bundle.getString("desc"));
            newDescFragImage.setImageResource(newsImageArray[position]);

        }


        int screenWidth = getScreenWidth();
        LinearLayout.LayoutParams parms = (LinearLayout.LayoutParams) newDescFragImage.getLayoutParams();
        parms.height = screenWidth*9/16;
        newDescFragImage.setLayoutParams(parms);
        newDescFragImage.invalidate();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle
                                          savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    // TODO: Rename method, update argument and hook method
   // into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof
                OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener)
                    context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}

