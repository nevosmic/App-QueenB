package com.example.queenb;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {
    //private int numOfTabs;
    private ArrayList<Fragment> mylist;
    private void initTabs(){
        mylist=new ArrayList<Fragment>();
        mylist.add(new InfoF());
        mylist.add(new NoasF());

        mylist.add(new KimsF());
        mylist.add(new SharonsF());
        mylist.add(new SmadarsF());
    }

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        initTabs();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mylist.get(position);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
}
