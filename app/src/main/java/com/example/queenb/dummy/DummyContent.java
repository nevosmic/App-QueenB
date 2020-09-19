package com.example.queenb.dummy;

import androidx.fragment.app.Fragment;

import com.example.queenb.KimsF;
import com.example.queenb.SmadarsF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();


    static {
        addItem(createDummyItem(1, "Smadar", new SmadarsF()));
        addItem(createDummyItem(2, "Kim", new KimsF()));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position, String name, Fragment destination) {
        return new DummyItem(String.valueOf(position), name, destination);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String text;
        public final Fragment destination;

        public DummyItem(String id, String text, Fragment destination) {
            this.id = id;
            this.text = text;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}