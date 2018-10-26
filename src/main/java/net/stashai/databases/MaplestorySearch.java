package net.stashai.databases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MaplestorySearch {

    public static String search(String term) {
        if (term.equals("?maplestory") || term.equals("?mp2")) {
            return "No page request found, please enter an item/page name after the maplestory command.";
        }
        return mapleData(term);
    }

    private static String mapleData(String term) {
        String URL = "https://maplestory2.gamepedia.com/MapleStory_2_Wiki";
        try {
            Document doc = Jsoup.connect("https://maplestory2.gamepedia.com/MapleStory_2_Wiki").get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.toString().toLowerCase().contains(term)) {
                    return "https://maplestory2.gamepedia.com" + link.attr("href");
                }
            }
        }
        catch (IOException e) {
            return null;
        }
        return "Page Could Not Be Found.";
    }
}
