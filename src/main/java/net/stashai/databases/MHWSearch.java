package net.stashai.databases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MHWSearch {

    public static String search(String item) {
        if (item.equals("?mhw")) {
            return "No page request found, please enter an item/page name after the mhw command.";
        }
        return mhwData(item);
    }

    private static String mhwData(String item) {
        try {
            Document doc = Jsoup.connect("https://monsterhunterworld.wiki.fextralife.com/Monster+Hunter+World+Wiki").get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.toString().toLowerCase().contains(item)) {
                    return "https://monsterhunterworld.wiki.fextralife.com" + link.attr("href");
                }
            }
            if (item.contains(" ")) {
                return "https://monsterhunterworld.wiki.fextralife.com/Monster+Hunter+World+Wiki#gsc.tab=0&gsc.q=" + item.replace(" ", "%20") + "&gsc.sort=";
            }
            return "https://monsterhunterworld.wiki.fextralife.com/Monster+Hunter+World+Wiki#gsc.tab=0&gsc.q=" + item + "&gsc.sort=";
        }
        catch (IOException e) {
            return null;
        }
    }
}
