package com.example.queenb;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.queenb.main_fragment.MainFragment;


public class NoasF extends Fragment {

    private Button who_are_we;

    public NoasF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoasF.
     */
    // TODO: Rename and change types and number of parameters
    public static NoasF newInstance(String param1, String param2) {
        NoasF fragment = new NoasF();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_noas, container, false);

        who_are_we = (Button)rootView.findViewById(R.id.who_are_we);
        who_are_we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),WhoAreWe2.class));

            }
        });
        return rootView;
    }
}