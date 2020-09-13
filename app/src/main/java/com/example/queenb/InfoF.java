package com.example.queenb;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoF extends Fragment {

    Button BeerSheva,Jerusalm1,Jerusalm2,Jerusalm3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoF.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoF newInstance(String param1, String param2) {
        InfoF fragment = new InfoF();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //paste here
//        BeerSheva = getView().findViewById(R.id.BeerSheva);
//        Jerusalm1 = getView().findViewById(R.id.Jerusalem1);
//        Jerusalm2 = getView().findViewById(R.id.Jerusalem2);
//        Jerusalm3 = getView().findViewById(R.id.Jerusalem3);

      //  BeerSheva.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
       //         Intent intent = new Intent(getActivity().getApplication(), MainActivityList.class);
       //         startActivity(intent);
        //    }
     //   });

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}