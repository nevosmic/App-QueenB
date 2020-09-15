package com.example.queenb;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoF extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button beerSheva;

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

    }
    void showDialog(String myText, Drawable myImg){
        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View view=inflater.inflate(R.layout.alert_dialog, null);

        ImageView imageView =(ImageView)view.findViewById(R.id.img);
        imageView.setImageDrawable(myImg);

        TextView mytext = (TextView)view.findViewById(R.id.mytext) ;
        mytext.setText(myText);

        AlertDialog alertDialog=new AlertDialog.Builder(this.getActivity())
                .setView(view)
                .create();
        alertDialog.show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
//        String s = String.valueOf(R.string.text1);
//        Drawable d = getResources().getDrawable(R.drawable.ic_launcher_foreground);
//        showDialog(s,d);
        List<InfoNode> myList = initInfo();
        for(InfoNode myNode : myList){
            TextView myT=view.findViewById(myNode.idName);
            String sourceString = "<b>" +myNode.city + "</b> " +myNode.place;
            // myT.setText(sourceString);
            // myT.setText(Html.fromHtml(sourceString));
        }

        //paste here
        beerSheva = view.findViewById(R.id.BeerSheva);
        beerSheva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String s = String.valueOf(R.string.text1);
                Drawable d = getResources().getDrawable(R.drawable.ic_launcher_foreground);
                showDialog(s,d);
            }
        });

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
        // Inflate the layout for this fragment
        return view;

    }
    private List<InfoNode> initInfo() {
        List<InfoNode> output = new ArrayList<>();
        output.add(new InfoNode(R.id.BeerSheva,"באר-שבע","אוניברסיטת בו-גוריון"));
        output.add(new InfoNode(R.id.Jerusalem1,"ירושלים","האוניברסיטה העברית, קמפוס גבעת רם"));
        output.add(new InfoNode(R.id.Jerusalem2,"ירושלים","המרכז לחדשנות טכנולוגית,גוננים"));
        output.add(new InfoNode(R.id.Jerusalem3,"ירושלים","מזרח ירושלים"));
        output.add(new InfoNode(R.id.Modiin,"חבל מודיעין","באופן מקוון"));
        output.add(new InfoNode(R.id.TelAviv1,"תל-אביב יפו","דרום ומזרח העיר"));
        output.add(new InfoNode(R.id.TelAviv2,"תל-אביב יפו","דרום ומזרח העיר"));
        output.add(new InfoNode(R.id.Hertzelia,"הרצליה","חברת Microsoft"));
        output.add(new InfoNode(R.id.KfarSaba,"כפר-סבא","חברת Western Digital"));
        output.add(new InfoNode(R.id.Haifa1,"חיפה","הטכניון"));
        output.add(new InfoNode(R.id.Haifa1,"חיפה","אוניברסיטת חיפה"));

        return output;
    }


}