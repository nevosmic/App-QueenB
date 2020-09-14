package com.example.queenb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {
    private Button WhoAreWe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabBar);


//        TabItem InfoTab =  findViewById(R.id.InfoTab);
//        TabItem SmadarsTab =  findViewById(R.id.SmadarsTab);
//        TabItem SharonsTab =  findViewById(R.id.SharonsTab);
//        TabItem KimsTab =  findViewById(R.id.KimsTab);
//        TabItem NoasTab =  findViewById(R.id.NoasTab);
        final ViewPager2 viewPager= findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter =new PagerAdapter(getSupportFragmentManager(),this.getLifecycle());
        viewPager.setAdapter(pagerAdapter);
        //tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        WhoAreWe = findViewById(R.id.who_are_we);
        WhoAreWe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhoAreWe();
            }
        });
    }
    public void openWhoAreWe(){
        Intent intent = new Intent(this, WhoAreWe.class);
        startActivity(intent);
    }
}