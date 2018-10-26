package net.stashai.databases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DestinySearch {

    public static String search(String item) {
        if (item.equals("?destiny") || item.equals("?d2")) {
            return "No page request found, please enter an item/page name after the destiny command.";
        }
        else if (item.contains(" ")) {
            String token = item.replaceAll(" ", "%20");
            return destinyData(token);
        }
        else {
            return destinyData(item);
        }
    }

    private static String destinyData(String item) {
        String URL = "http://db.planetdestiny.com";
        try {
            Document doc = Jsoup.connect("http://db.planetdestiny.com/items/search/" + item).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.toString().contains("/items/view/")) {
                    return URL + (link.attr("href"));
                }
            }
            return "http://db.planetdestiny.com/items/search/" + item;
        }
        catch (IOException e) {
            return null;
        }
    }
}
