package com.example.queenb.menu;

import androidx.fragment.app.Fragment;

import com.example.queenb.InfoF;
import com.example.queenb.KimsF;
import com.example.queenb.NoasF;
import com.example.queenb.SharonsF;
import com.example.queenb.SmadarsF;

import java.util.ArrayList;
import java.util.List;

public class MenuContent {
    public static final List<MenuButtonItem> ITEMS = new ArrayList<MenuButtonItem>();
    static {
        ITEMS.add(new MenuButtonItem("מי אנחנו?", new NoasF()));
        ITEMS.add(new MenuButtonItem("הטריויה שתשנה את חייך", new SmadarsF()));
        //TODO: change the dest here to not null
        ITEMS.add(new MenuButtonItem("לא בטוחה? אולי חניכה לשעבר תספר לך!", new KimsF()));
        ITEMS.add(new MenuButtonItem("פרויקטים לדוגמה של חניכות", new SharonsF()));
        //TODO: needed a line between those
        ITEMS.add(new MenuButtonItem("הירשמי עכשיו", new InfoF()));
    }

    public static class MenuButtonItem {
        public final String text;
        public final Fragment destination;

        public MenuButtonItem(String text, Fragment destination) {
            this.text = text;
            this.destination = destination;
        }

    }
}