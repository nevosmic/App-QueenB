package com.example.queenb.main_fragment;

import androidx.fragment.app.Fragment;

import com.example.queenb.InfoF;
import com.example.queenb.KimsF;
import com.example.queenb.NoasF;
import com.example.queenb.SharonsF;
import com.example.queenb.SmadarsF;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentContent {
    public static final List<MainFragmentButtonItem> ITEMS = new ArrayList<MainFragmentButtonItem>();
    static {
        ITEMS.add(new MainFragmentButtonItem("Info", new InfoF()));
        ITEMS.add(new MainFragmentButtonItem("Smadar", new SmadarsF()));
        ITEMS.add(new MainFragmentButtonItem("Kim", null));//TODO
        ITEMS.add(new MainFragmentButtonItem("Noa", new NoasF()));
        ITEMS.add(new MainFragmentButtonItem("Sharon", new SharonsF()));
    }

    public static class MainFragmentButtonItem {
        public final String text;
        public final Fragment destination;

        public MainFragmentButtonItem(String text, Fragment destination) {
            this.text = text;
            this.destination = destination;
        }
    }
}