package com.iss.sa4108.android_fragments;

import java.util.ArrayList;
import java.util.HashMap;

public class Item extends HashMap<String, String> {
    private static final long serialVersionUID = -4444602266741220062L;
    private static ArrayList<Item> parts = null;

    public static ArrayList<Item> getParts() {
        if (parts == null) {
            ArrayList<Item> c = new ArrayList<Item>();
            c.add(new Item("P1001", "Screw 10mm", 7));
            c.add(new Item("P1002", "Nut 10mm", 5));
            c.add(new Item("P1101", "Screw and nut set", 12));
            parts = c;
        }
        return(parts);
    }

    public Item(String id, String description, int cost) {
        put("id", id);
        put("description", description);
        put("cost", Integer.toString(cost));
    }
}