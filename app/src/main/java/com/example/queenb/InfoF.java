package com.example.queenb;

import android.app.AlertDialog;

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
import java.util.ArrayList;
import java.util.List;

public class InfoF extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button beerSheva,jerusalem1;

    public InfoF() {
        // Required empty public constructor
    }

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
    void showDialog(String myText, String myText2, Drawable myImg,Drawable myImg2){
        
        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View view=inflater.inflate(R.layout.alert_dialog, null);
        
        ImageView imageView =(ImageView)view.findViewById(R.id.img);
        ImageView imageView2 =(ImageView)view.findViewById(R.id.img2);
        imageView.setImageDrawable(myImg);
        imageView2.setImageDrawable(myImg2);

        TextView mytext = (TextView)view.findViewById(R.id.mytext) ;
        TextView mytext2 =  (TextView)view.findViewById(R.id.mytext2);
        mytext.setText(myText);
        mytext2.setText(myText2);

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
            int idnames=myNode.getIdName();
            TextView myT=view.findViewById(idnames);
            String sourceString = "<b>" +myNode.city + "</b> " +myNode.place;
             myT.setText(sourceString);
             myT.setText(Html.fromHtml(sourceString));
        }

        //paste here
        beerSheva = view.findViewById(R.id.BeerSheva);

        beerSheva.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String s = "הפעילות תתקיים באוניברסיטת בן-גוריון בבאר-שבע. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון";
                String s2 = "המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00.\n" +
                        "במוקד יפתחו\n" +
                        "קבוצות מתחילות (כיתה ח׳) בימים א׳/ב׳\n" +
                        "קבוצת ממשיכות (כיתה ט׳) ביום ד׳";
               // String s2 = Resources.getSystem().getString(R.string.text1);;
                       // String.valueOf();
                Drawable d = getResources().getDrawable(R.drawable.ic_launcher_foreground);
                Drawable d2 = getResources().getDrawable(R.drawable.ic_launcher_foreground);
              //  Drawable d = ContextCompat.getDrawable(getActivity(), R.drawable.photo2);
                showDialog(s,s2,d,d2);
            }
        });

//        Jerusalm1 = getView().findViewById(R.id.Jerusalem1);
//        Jerusalm2 = getView().findViewById(R.id.Jerusalem2);
//        Jerusalm3 = getView().findViewById(R.id.Jerusalem3);


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