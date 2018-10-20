package net.stashai.utils;

public class DestinySearch {

    public static String URL = "http://db.planetdestiny.com/items/search/";

    public static String search(String item) {
        if (item.equals("?destiny") || item.equals("?d2")) {
            return "No page request found, please enter an item/page name after the destiny command.";
        }
        else if (item.contains(" ")) {
            String token = item.replaceAll(" ", "%20");
            return URL + token;
        }
        else {
            return URL + item;
        }
    }
}
