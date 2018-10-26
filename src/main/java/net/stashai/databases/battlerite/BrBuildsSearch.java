package net.stashai.databases.battlerite;

public class BrBuildsSearch {

    private static String URL = "https://www.battleritebuilds.com/characters/";

    public static String buildSearch(String champ) {
        if (champ.equals("?brbuilds")) {
            return "No page request found, please enter a champion name after the battlerite builds command";
        }

        String[] champs = {"bakko", "freya", "croak", "raigon", "rook", "ashka", "thorn", "oldur", "blossom", "jumong", "lucie"
                , "pestilus", "shifu", "ezmo", "iva", "jamila", "pearl", "poloma", "sirius", "varesh", "alysia", "destiny"
                , "jade", "ruh kaan", "taya", "ulric", "zander"};

        for (String s:champs) {
            if (champ.equals(s)) {
                if (champ.contains(" ")) {
                    champ = champ.replace(" ", "-");
                }
                return URL + champ;
            }
        }
        return "Champion could not be found, the Champion either doesn't exist or is not yet implemented into the bot's database. Thank you.";
    }
}
