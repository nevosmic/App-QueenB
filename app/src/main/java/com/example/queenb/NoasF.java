package com.example.queenb;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.queenb.main_fragment.MainFragment;


public class NoasF extends Fragment {

    private Button who_are_we;

    public NoasF() {
        // Required empty public constructor
    }


    public static NoasF newInstance(String param1, String param2) {
        NoasF fragment = new NoasF();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noas, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        LinearLayout gallery = view.findViewById(R.id.gallery);
       // gallery.removeAllViews();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        for(int i=0;i<7;i++){
               View myView = layoutInflater.inflate(R.layout.item1, gallery,false);
                //one image for example
                int imageSource = R.drawable.q10;
                ImageView image1 = myView.findViewById(R.id.imageView1);
                image1.setImageResource(imageSource);
                gallery.addView(myView);
            }




    }
}