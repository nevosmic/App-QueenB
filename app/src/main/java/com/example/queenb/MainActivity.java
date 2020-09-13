package com.example.queenb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem InfoTab =  findViewById(R.id.InfoTab);
        TabItem SmadarsTab =  findViewById(R.id.SmadarsTab);
        TabItem SharonsTab =  findViewById(R.id.SharonsTab);
        TabItem KimsTab =  findViewById(R.id.KimsTab);
        TabItem NoasTab =  findViewById(R.id.NoasTab);
        final ViewPager viewPager= findViewById(R.id.viewager);

        PagerAdapter pagerAdapter =new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
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


    }
}