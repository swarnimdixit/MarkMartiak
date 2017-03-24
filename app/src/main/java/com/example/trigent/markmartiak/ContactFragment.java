package com.example.trigent.markmartiak;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;


public class ContactFragment extends Fragment {

ImageButton IBFaceBook,IBTwitter,IBLinkedIn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        IBFaceBook = (ImageButton) view.findViewById(R.id.contact_frag_ib_fb);
        IBTwitter = (ImageButton) view.findViewById(R.id.contact_frag_ib_twit);
        IBLinkedIn = (ImageButton) view.findViewById(R.id.contact_frag_ib_linkedin);



        return inflater.inflate(R.layout.fragment_contact, container, false);
    }



}
