package com.example.queenb;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class InfoF extends Fragment
{
    //buttons
    MaterialCardView beerSheva,jerusalem1,jerusalem2,jerusalem3,modiin,telAviv1,telAviv2,hertzelia,kfarsaba,haifa1,haifa2;

    public InfoF()
    {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    //happens when clicking on one of the card views, shows the details
    void showDialog(String myText, String myText2, String myText3, String myText4){
        
        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View view=inflater.inflate(R.layout.alert_dialog, null);

        TextView where = (TextView)view.findViewById(R.id.where) ;
        TextView when =  (TextView)view.findViewById(R.id.when);
        TextView what =  (TextView)view.findViewById(R.id.what);
        TextView who =  (TextView)view.findViewById(R.id.who);


        where.setText(myText);
        when.setText(myText2);
        what.setText(myText3);
        who.setText(myText4);

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
            if (view.findViewById(idnames) instanceof TextView)
            {
                TextView myT=view.findViewById(idnames);

                String sourceString = "<b>" +myNode.city + "</b> " +myNode.place;
                myT.setText(sourceString);
                myT.setText(Html.fromHtml(sourceString));
            }
            else if(view.findViewById(idnames) instanceof MaterialCardView)
            {

            }
        }


        beerSheva = view.findViewById(R.id.BeerSheva);
        String where = "הפעילות תתקיים באוניברסיטת בן-גוריון בבאר-שבע." +
                " במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String when = "אחת לשבוע בין השעות 17:00-20:00. " +
                "יפתחו קבוצות למתחילות (כיתה ח׳) בימים א׳/ב׳," +
                "וקבוצת ממשיכות (כיתה ט׳) ביום ד׳.";
        String what = "תכנות בשפת Java Script.";
        String who = "אין מבחני קבלה, אין צורך בידע קודם, או בידע מעמיק במתמטיקה או במחשבים!";
        Drawable d2 = ResourcesCompat.getDrawable(getResources(),R.drawable.photo2,getContext().getTheme() );
        cardViewSetOnClick(beerSheva, where, when, what, who);

        jerusalem1 = view.findViewById(R.id.Jerusalem1);
        where = "קמפוס גבעת רם של האוניברסיטה העברית בירושלים. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when ="אחת לשבוע בין השעות 17:00-20:00. יפתחו קבוצות מתחילות (כיתה ח׳) בימים א׳, ב׳, ד׳ וה׳, קבוצות ממשיכות (כיתה ט׳) וקבוצת למידה (כיתה י׳) ביום ב׳/ד׳.";
        cardViewSetOnClick(jerusalem1, where, when, what, who);

        jerusalem2 = view.findViewById(R.id.Jerusalem2);
        where = "במרכז החדשנות גוננים בירושלים. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when ="אחת לשבוע בין השעות 17:00-20:00. ההרשמה למוקד זה תפתח בקרוב.";
        cardViewSetOnClick(jerusalem2, where, when, what, who);

        jerusalem3 = view.findViewById(R.id.Jerusalem3);
        where = "מזרח העיר, מיקום מדויק יפורסם בהמשך.";
        when ="אחת לשבוע בין השעות 17:00-20:00. יום הפעילות יפורסם בהמשך.";
        cardViewSetOnClick(jerusalem3, where, when, what, who);

        modiin = view.findViewById(R.id.Modiin);
        where = "הפעילות תתקיים באופן מקוון. ההרשמה פתוחה לתושבות איזור חבל מודיעין בלבד.";
        when ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. תיפתח קבוצת מתחילות (כיתה ח')ביום ב'.";
        cardViewSetOnClick(modiin, where, when, what, who);

        telAviv1 = view.findViewById(R.id.TelAviv1);
        where = "תל אביב, מיקום הפעילות יפורסם בהמשך.";
        when ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. יום הפעילות יפורסם בהמשך";
        cardViewSetOnClick(telAviv1, where, when, what, who);

        telAviv2 = view.findViewById(R.id.TelAviv2);
        where = "אוניברסיטת תל-אביב. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. יפתחו קבוצות מתחילות (כיתה ח׳) בימים א׳ וה, קבוצות ממשיכות (כיתה ט׳) בימים א' וה' ומרכז למידה (כיתה י׳) בשרונה האב בימי א'.";
        cardViewSetOnClick(telAviv2, where, when, what, who);

        hertzelia = view.findViewById(R.id.Hertzelia);
        where = "הפעילות תתקיים במשרדי חברת מיקרוסופט בהרצליה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when = "המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. תפתח קבוצת מתחילות (כיתה ח') ביום ב'.'";
        cardViewSetOnClick(hertzelia, where, when, what, who);

        kfarsaba = view.findViewById(R.id.KfarSaba);
        where ="הפעילות תתקיים במשרדי חברת ווסטרן דיגיטל בכפר-סבא. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. במוקד יפתחו קבוצת מתחילות (כיתה ח׳) בעברית ביום ד', קבוצת מתחילות (כיתה ח׳) בערבית ביום ד' וקבוצת ממשיכות (כיתה ט׳) דו-לשונית ביום ד'.";
        cardViewSetOnClick(kfarsaba, where, when, what, who);

        haifa1 = view.findViewById(R.id.Haifa1);
        where ="הפעילות תתקיים בקמפוס הטכניון בחיפה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        when ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. במוקד יפתחו קבוצות מתחילות (כיתה ח׳) בימים א' וה' וקבוצות ממשיכות (כיתה ט׳) בימים א' וה' ";
        cardViewSetOnClick(haifa1, where, when, what, who);

        haifa2 = view.findViewById(R.id.Haifa2);
        when = "המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00. ההרשמה למוקד זה תפתח בקרוב.";
        where ="אוניברסיטת חיפה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        cardViewSetOnClick(haifa2, where, when, what, who);

        view.findViewById(R.id.registerNow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registerButton();
            }
        });
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
        output.add(new InfoNode(R.id.Haifa2,"חיפה","אוניברסיטת חיפה"));

        return output;
    }
    private void cardViewSetOnClick(MaterialCardView btn,final String str1, final String str2, final String str3, final String str4){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(str1, str2, str3, str4);
            }
        });
    }

    public void registerButton() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.queenb.org.il/signup"));
        startActivity(intent);
    }


}