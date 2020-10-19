package com.example.queenb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.queenb.trivia.MainTriviaF;


public class SmadarsF extends Fragment {
    public SmadarsF() {
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
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MainTriviaF()).addToBackStack(null).commit();
            }
        });
        return v;
    }
}