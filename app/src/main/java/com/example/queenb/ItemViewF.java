package com.example.queenb;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemViewF extends Fragment {

    //private static final String ITEM = "item";
    //private ItemsModel mItem;

    ImageView imageView;
    TextView nameTextView, ageTextView, locationTextView, question_one, question_two, lovedTextView, recommendTextView;
    ItemsModel girlItem;

    public static ItemViewF newInstance()
    {
        ItemViewF fragment = new ItemViewF();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_view, container, false);


        ImageButton whatsapp_button, insta_button;
        question_one = v.findViewById(R.id.question_one);
        question_two = v.findViewById(R.id.question_two);
        imageView = v.findViewById(R.id.imageViewItem);
        nameTextView = v.findViewById(R.id.nameTextViewItem);
        ageTextView = v.findViewById(R.id.ageTextViewItem);
        locationTextView = v.findViewById(R.id.locationTextViewItem);
        whatsapp_button = v.findViewById(R.id.whatsapp_button);
        insta_button = v.findViewById(R.id.insta_button);
        lovedTextView = v.findViewById(R.id.lovedTextViewItem);
        recommendTextView = v.findViewById(R.id.recommendTextViewItem);


        girlItem =(ItemsModel) getArguments().getSerializable("item");
        //Set the value to your text view

        imageView.setImageResource(girlItem.getImage_of_quote());
        nameTextView.setText(girlItem.getName());
        ageTextView.setText(girlItem.getAge());
        locationTextView.setText(girlItem.getLocation());
        lovedTextView.setText(girlItem.getLoved());
        recommendTextView.setText(girlItem.getRecommend_queenb());
        question_one.setText("מה הדבר שהכי אהבת ב-QueenB?");
        question_two.setText("למה את ממליצה להירשם לתוכנית של QueenB?");


        whatsapp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = girlItem.getPhoneNumber(); //TODO change to girl1 number
                String message = "היי " + girlItem.getName() +
                        ", הגעתי אלייך דרך האפליקציה של QueenB, אשמח לשמוע ממך קצת על איך זה להיות חניכה.. :)";
                boolean isInstalled = appInstalledOrNot("com.whatsapp");
                if(isInstalled){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ mobileNumber+ "&text="+ message));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(),"אפליקציית וואטסאפ אינה מותקנת על המכשיר", Toast.LENGTH_SHORT).show();
                }
            }
        });

        insta_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(girlItem.getInstagram()); //TODO try 2
                if(!(girlItem.getInstagram().equals("no account"))){
                    Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
                    instagram.setPackage("com.instagram.android");
                    try{
                        startActivity(instagram);
                    } catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(girlItem.getInstagram()))); //TODO try2
                    }
                }
                else{
                    Toast.makeText(getContext(),"לא קיים קישור למשתמש באינסטגרם", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }

    private boolean appInstalledOrNot(String url){
        PackageManager packageManager = getActivity().getPackageManager();
        boolean app_installed;
        try{
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch(PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}