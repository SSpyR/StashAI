package net.stashai.utils;

public class DestinySearch {

    public static String URL = "http://db.planetdestiny.com/items/search/";

    public static String search(String item) {
        if (item.contains(" ")) {
            String [] tokens = item.split(" ");
            if (tokens.length == 2) {
                return URL + tokens[0] + "%20" + tokens[1];
            }
            if (tokens.length == 3) {
                return URL + tokens[0] + "%20" + tokens[1] + "%20" + tokens[2];
            }
            if (tokens.length == 4) {
                return URL + tokens[0] + "%20" + tokens[1] + "%20" + tokens[2] + "%20" + tokens[3];
            }
            if (tokens.length == 5) {
                return URL + tokens[0] + "%20" + tokens[1] + "%20" + tokens[2] + "%20" + tokens[3] + "%20" + tokens[4];
            }
        }
        else {
            return URL + item;
        }
        return null;
    }
}
