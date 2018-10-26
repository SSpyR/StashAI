package net.stashai.databases.dnd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PathfinderSearch {

    public static String search(String term) {
        if (term.equals("?pathfinder") || term.equals("?pf")) {
            return "No page request found, please enter an item/page name after the pathfinder command.";
        }
        return pfData(term);
    }

    private static String pfData(String term) {
        try {
            Document doc = Jsoup.connect("https://www.d20pfsrd.com/").get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.toString().contains(term)) {
                    return link.attr("href");
                }
            }
        }
        catch (IOException e) {
            return null;
        }
        return "Page Could Not Be Found.";
    }
}
