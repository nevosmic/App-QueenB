package com.example.queenb;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemViewActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nameTextView;
    TextView ageTextView;
    TextView locationTextView;
    ItemsModel itemsModel;
    Button whatsapp_button;
    Button insta_button;
    TextView question_one;
    TextView question_two;
    TextView lovedTextView;
    TextView recommendTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        question_one = findViewById(R.id.question_one);
        question_two = findViewById(R.id.question_two);
        imageView = findViewById(R.id.imageViewItem);
        nameTextView = findViewById(R.id.nameTextViewItem);
        ageTextView = findViewById(R.id.ageTextViewItem);
        locationTextView = findViewById(R.id.locationTextViewItem);
        whatsapp_button = findViewById(R.id.whatsapp_button);
        insta_button = findViewById(R.id.insta_button);
        lovedTextView = findViewById(R.id.lovedTextViewItem);
        recommendTextView = findViewById(R.id.recommendTextViewItem);

        Intent intent = getIntent();

        if(intent.getExtras() != null){         //what are these lines for?
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            imageView.setImageResource(itemsModel.getImage_of_quote());
            nameTextView.setText(itemsModel.getName());
            ageTextView.setText(itemsModel.getAge());
            locationTextView.setText(itemsModel.getLocation());
            lovedTextView.setText(itemsModel.getLoved());
            recommendTextView.setText(itemsModel.getRecommend_queenb());
            question_one.setText("מה הדבר שהכי אהבת ב-QueenB?");
            question_two.setText("למה את ממליצה להירשם לתוכנית של QueenB?");
        }


        whatsapp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = itemsModel.getPhoneNumber(); //TODO change to girl1 number
                String message = "היי " + itemsModel.getName() +
                        ", הגעתי אלייך דרך האפליקציה של QueenB, אשמח לשמוע ממך קצת על איך זה להיות חניכה.. :)";
                boolean isInstalled = appInstalledOrNot("com.whatsapp");
                if(isInstalled){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ mobileNumber+ "&text="+ message));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ItemViewActivity.this,"אפליקציית וואטסאפ אינה מותקנת על המכשיר", Toast.LENGTH_SHORT).show();
                }
            }
        });

        insta_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(itemsModel.getInstagram()); //TODO try 2
                if(!(itemsModel.getInstagram().equals("no account"))){
                    Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
                    instagram.setPackage("com.instagram.android");
                    try{
                        startActivity(instagram);
                    } catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(itemsModel.getInstagram()))); //TODO try2
                    }
                }
                else{
                    Toast.makeText(ItemViewActivity.this,"לא קיים קישור למשתמש באינסטגרם", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean appInstalledOrNot(String url){
        PackageManager packageManager = getPackageManager();
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