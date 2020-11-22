package com.example.queenb.menu;

import androidx.fragment.app.Fragment;

import com.example.queenb.InfoF;
import com.example.queenb.QueenBEmbassyF;
import com.example.queenb.WhoAreWeF;
import com.example.queenb.ProjectsF;
import com.example.queenb.TriviaF;

import java.util.ArrayList;
import java.util.List;

public class MenuContent {
    public static final List<MenuButtonItem> ITEMS = new ArrayList<MenuButtonItem>();
    static {
        ITEMS.add(new MenuButtonItem("מי אנחנו?", new WhoAreWeF()));
        ITEMS.add(new MenuButtonItem("הטריויה שתשנה את חייך", new TriviaF()));
        //TODO: change the dest here to not null
        ITEMS.add(new MenuButtonItem("לא בטוחה? אולי חניכה לשעבר תספר לך!", new QueenBEmbassyF()));
        ITEMS.add(new MenuButtonItem("פרויקטים לדוגמה של חניכות", new ProjectsF()));
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