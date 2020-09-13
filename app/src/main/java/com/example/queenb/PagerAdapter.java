package com.example.queenb;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter{
    private int numOfTabs;
    public PagerAdapter(FragmentManager fm, int numOftabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new InfoF();
            case 1:
                return new NoasF();
            case 2:
                return new KimsF();
            case 3:
                return new SmadarsF();
            case 4:
                return new SharonsF();
            default:
                return null;

        }
        //return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
