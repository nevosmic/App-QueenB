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
    //buttons
    Button beerSheva,jerusalem1,jerusalem2,jerusalem3,modiin,telAviv1,telAviv2,hertzelia,kfarsaba,haifa1,haifa2;

    public InfoF() {
        // Required empty public constructor
    }


    public static InfoF newInstance(String param1, String param2) {
        InfoF fragment = new InfoF();
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


        beerSheva = view.findViewById(R.id.BeerSheva);
        String s1 = "הפעילות תתקיים באוניברסיטת בן-גוריון בבאר-שבע. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s2 = "המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00.\n במוקד יפתחו \nקבוצות מתחילות (כיתה ח׳) בימים א׳/ב׳ \nקבוצת ממשיכות (כיתה ט׳) ביום ד׳\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        Drawable d1 = getResources().getDrawable(R.drawable.photo1);
        Drawable d2 = getResources().getDrawable(R.drawable.therealqueenb);
        setOnClick(beerSheva, s1, s2, d1,d2);

        jerusalem1 = view.findViewById(R.id.Jerusalem1);
        String s3 = "הפעילות תתקיים בקמפוס גבעת רם של האוניברסיטה העברית בירושלים. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s4 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00 \nבמוקד יפתחו \nקבוצות מתחילות (כיתה ח׳) בימים א׳, ב׳, ד׳ וה׳ \nקבוצות ממשיכות (כיתה ט׳) \nקבוצת למידה (כיתה י׳) ביום ב׳/ד׳ \n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(jerusalem1, s3, s4, d1,d2);

        jerusalem2 = view.findViewById(R.id.Jerusalem2);
        String s5 = "הפעילות תתקיים במרכז החדשנות גוננים בירושלים. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s6 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00.\n\nההרשמה למוקד זה תפתח בקרוב.\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(jerusalem2, s5, s6, d1,d2);

        jerusalem3 = view.findViewById(R.id.Jerusalem3);
        String s7 = "מיקום הפעילות יפורסם בהמשך.";
        String s8 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00.\n\nיום הפעילות יפורסם בהמשך.\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(jerusalem3, s7, s8, d1,d2);

        modiin = view.findViewById(R.id.Modiin);
        String s9 = "הפעילות תתקיים באופן מקוון\nההרשמה פתוחה לתושבות איזור חבל מודיעין בלבד.";
        String s10 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00.\n\nקבוצת מתחילות (כיתה ח')ביום ב'.\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(modiin, s9, s10, d1,d2);
        telAviv1 = view.findViewById(R.id.TelAviv1);
        setOnClick(telAviv1, s7, s8, d1,d2);
        telAviv2 = view.findViewById(R.id.TelAviv2);
        String s11 = "הפעילות תתקיים באוניברסיטת תל-אביב. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s12 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00 \nבמוקד יפתחו \nקבוצות מתחילות (כיתה ח׳) בימים א׳ וה' \nקבוצות ממשיכות (כיתה ט׳) בימים א' וה' \nמרכז למידה (כיתה י׳) בשרונה האב בימי א'\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(telAviv2, s11, s12, d1,d2);
        hertzelia = view.findViewById(R.id.Hertzelia);
        String s13 = "הפעילות תתקיים במשרדי חברת מיקרוסופט בהרצליה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s14 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00 \nבמוקד תפתח קבוצת מתחילות (כיתה ח') ביום ב'\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(hertzelia, s11, s12, d1,d2);
        kfarsaba = view.findViewById(R.id.KfarSaba);
        String s15 ="הפעילות תתקיים במשרדי חברת ווסטרן דיגיטל בכפר-סבא. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s16 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00 \nבמוקד יפתחו \nקבוצת מתחילות (כיתה ח׳) בעברית ביום ד' \nקבוצת מתחילות (כיתה ח׳) בערבית ביום ד' \nקבוצת ממשיכות (כיתה ט׳) דו-לשונית ביום ד'\n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(kfarsaba, s15, s16, d1,d2);
        haifa1 = view.findViewById(R.id.Haifa1);
        String s17 ="הפעילות תתקיים בקמפוס הטכניון בחיפה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
        String s18 ="המפגשים מתקיימים אחת לשבוע בין השעות 17:00-20:00 \nבמוקד יפתחו \nקבוצות מתחילות (כיתה ח׳) בימים א' וה' \nקבוצות ממשיכות (כיתה ט׳) בימים א' וה' \n\nהחניכות ילמדו תכנות בשפת Java Script, בהדרכת מלגאיות שהן סטודנטיות למדעי המחשב והנדסה. אין מבחני קבלה, אין צורך בידע קודם, אין צורך בידע מעמיק במתמטיקה או במחשבים";
        setOnClick(haifa1, s17, s18, d1,d2);
        haifa2 = view.findViewById(R.id.Haifa2);
        String s19 ="הפעילות תתקיים באוניברסיטת חיפה. במידת הצורך ובכפוף להנחיות משרד החינוך והבריאות הפעילות תתקיים באופן מקוון.";
       setOnClick(haifa2, s19, s6, d1,d2);

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

    private void setOnClick(Button btn,final String str1, final String str2, final Drawable d1, final Drawable d2){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(str1,str2,d1,d2);
            }
        });
    }

}