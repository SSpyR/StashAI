package net.stashai.databases.battlerite;

public class BattleriteSearch {

    public static String search(String champ) {
        String URL = "https://topplerite.com/guide?target=";

        if (champ.equals("?battlerite") || champ.equals("?br")) {
            return "No page request found, please enter a champion name after the battlerite command";
        }

        String[] champs = {"Bakko", "Freya", "Croak", "Raigon", "Rook", "Ashka", "Thorn", "Oldur", "Blossom", "Jumong", "Lucie"
                            , "Pestilus", "Shifu", "Ezmo", "Iva", "Jamila", "Pearl", "Poloma", "Sirius", "Varesh", "Alysia", "Destiny"
                            , "Jade", "Ruh Kaan", "Taya", "Ulric", "Zander"};

        if (champ.contains(" ")) {
            String [] a = champ.split(" ");
            String s1 = a[0];
            s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1);
            String s2 = a[1];
            s2 = s2.substring(0, 1).toUpperCase() + s2.substring(1);
            champ = s1 + " " + s2;
        }

        champ = champ.substring(0, 1).toUpperCase() + champ.substring(1);

        for (String s:champs) {
            if (champ.equals(s)) {
                if (champ.contains(" ")) {
                    champ = champ.replace(" ", "%20");
                }
                return URL + champ;
            }
        }

        return "Champion could not be found, the Champion either doesn't exist or is not yet implemented into the bot's database. Thank you.";
    }
}
