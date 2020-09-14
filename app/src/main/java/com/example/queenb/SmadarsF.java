package com.example.queenb;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SmadarsF extends Fragment
{
    public SmadarsF()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // graphical initializations heres
        View v = inflater.inflate(R.layout.fragment_smadars, container, false);
        //PlayGame button - it will take you to the MainGameActivity
        Button startTrivia = v.findViewById(R.id.startTrivia);
        startTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,
                        new MainTriviaF()).addToBackStack(null).commit();
            }
        });
        return v;
    }
    //=============== open source quiz ==============================


/*
    private void initViews() {
        //initialize views here
        playGame =(FButton)findViewById(R.id.playGame);
        quit = (FButton) findViewById(R.id.quit);
        tQ = (TextView)findViewById(R.id.tQ);

        //Typeface - this is for fonts style
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        playGame.setTypeface(typeface);
        quit.setTypeface(typeface);
        tQ.setTypeface(typeface);
    }*/
}