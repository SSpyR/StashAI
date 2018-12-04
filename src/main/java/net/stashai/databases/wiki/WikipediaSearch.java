package net.stashai.databases.wiki;

public class WikipediaSearch {

    public static String search(String term) {
        if (term.equals("?wiki")) {
            return "No page request found, please enter an term/page name after the wiki command.";
        }
        if (term.contains(" ")) {
            String [] w = term.split(" ");
            String newterm = "";
            for (int i = 0; i < w.length; i++) {
                newterm += w[i].substring(0,1).toUpperCase() + w[i].substring(1);
                if ((i + 1) < w.length) {
                    newterm += "_";
                }
            }
            return "https://en.wikipedia.org/wiki/" + newterm;
        }
        else {
            term = term.substring(0, 1).toUpperCase() + term.substring(1);

            return "https://en.wikipedia.org/wiki/" + term;
        }
    }
}
