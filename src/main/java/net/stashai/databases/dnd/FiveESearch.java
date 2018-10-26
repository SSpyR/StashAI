package net.stashai.databases.dnd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FiveESearch {

    public static String search(String term) {
        if (term.equals("?dnd") || term.equals("?5e")) {
            return "No page request found, please enter an item/page name after the 5e/dnd command.";
        }

        return dndData(term);
    }

    private static String dndData(String term) {
        try {
            Document doc = Jsoup.connect("https://roll20.net/compendium/dnd5e/BookIndex").get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.toString().toLowerCase().contains(term)) {
                    return "https://roll20.net" + link.attr("href");
                }
            }
        }
        catch (IOException e) {
            return null;
        }
        return "Page Could Not Be Found";
    }
}
