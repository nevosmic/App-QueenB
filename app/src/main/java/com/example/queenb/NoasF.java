package com.example.queenb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoasF extends Fragment {

   // private Button who_are_we;
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
        View v = inflater.inflate(R.layout.fragment_noas, container, false);
        ImageButton facebook, insta, site;
        //set header text
        String header_text = "ב-2015 סטודנטיות למדעי המחשב התבוננו סביבן והבחינו, לצערן, שיש מעט מדי נשים סביבן. " +
                "מתוך רצון לשנות מציאות זו קמה QueenB, כעמותה השמה לעצמה למטרה להעלות את הייצוג הנשי בתחום הטכנולוגי.";
        final TextView header = (TextView) v.findViewById(R.id.who_are_we);
        header.setText(header_text);

        //set the first elaboration text
        String elaboration1_text = "על אף שבגילאי היסודי הישגיהן של בנות זהים לאלו של בנים, " +
                "הן מסתייגות מתחומים טכנולוגים ובמגמות מחשבים בתיכון ישנן רק כ-30% תלמידות. " +
                "הרתיעה נמשכת גם בשלבי חיים מאוחרים יותר, ואחוז הנשים בתחומים אלו באקדמיה ובתעשייה אף נמוך מכך.\n" +

                "\u200B\n" +

                "מטרת העמותה היא לייצר תחושת מסוגלות בקרב נערות ונשים לגבי יכולתן לעסוק בכל מקצוע שיבחרו." +
                " פעילותנו המרכזית היא תכנית מלגות שבה סטודנטיות למדעי המחשב מלמדות נערות בכיתה ח' תכנות. " +
                "במסגרת פעילות העמותה סטודנטיות למדעי המחשב זוכות לעבוד יחדיו וכן לקחת חלק באירועים משותפים." +
                " בכך אנחנו מקוות לייצר קבוצה חברתית מגובשת של נשים מוכשרות וחזקות.";
        final TextView elaboration1 = (TextView) v.findViewById(R.id.elaboration1);
        elaboration1.setText(elaboration1_text);
        insta = v.findViewById(R.id.insta_button);
        facebook = v.findViewById(R.id.facecbook);
        site = v.findViewById(R.id.queenbSiteButton);

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/queenbprogram/"));
                startActivity(intent);

            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/queenb.program"));
                startActivity(intent);

            }
        });

        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.queenb.org.il/"));
                startActivity(intent);

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        //int[] galleryIds = {R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3,
        //        R.drawable.gallery4, R.drawable.gallery5, R.drawable.gallery6, R.drawable.gallery7, R.drawable.gallery8};
        //LinearLayout.LayoutParams imParams =
         //       new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
         //               LinearLayout.LayoutParams.MATCH_PARENT);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        //    imParams.setMarginEnd(8);
        //}
        //for (int i = 0; i < galleryIds.length; ++i)
        //{
        //    ImageView image = new ImageView(getContext());
        //    image.setImageResource(galleryIds[i]);
         //   image.setAdjustViewBounds(true);
         //   gallery.addView(image, imParams);
        //}
    }

}