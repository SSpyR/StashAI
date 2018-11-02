package net.stashai.databases;

public class WoWSearch {

    public static String search(String item) {
        String URL = "https://www.wowhead.com/search?q=";
        if (item.equals("?wow")) {
            return "No page request found, please enter an item/page name after the wow command.";
        }
        else if (item.contains(" ")) {
            String token = item.replaceAll(" ", "+");
            return URL + token;
        }
        else {
            return URL + item;
        }
    }
}
