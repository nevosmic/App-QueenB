package com.example.queenb.trivia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.queenb.R;
import com.example.queenb.main_fragment.MainFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FinalTrivia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinalTrivia extends Fragment {



    public FinalTrivia()
    {
        // Required empty public constructor
    }


    public static FinalTrivia newInstance()
    {
        FinalTrivia fragment = new FinalTrivia();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_final_trivia, container, false);
        Button finnish = (Button) v.findViewById(R.id.finishBtn);
        finnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Fragment mainFragment = MainFragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
            }
        });

        return  v;
    }
}