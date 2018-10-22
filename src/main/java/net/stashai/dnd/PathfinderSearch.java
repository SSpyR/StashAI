package net.stashai.dnd;

public class PathfinderSearch {

    public static String URL = "https://www.d20pfsrd.com/";

    //TODO add more races, and maybe start adding other pages as well
    public static String search(String term) {
        if (term.equals("?pathfinder") || term.equals("?pf")) {
            return "No page request found, please enter an item/page name after the pathfinder command.";
        }

        //simple navigation pages
        if (term.equals("races")) {
            return URL + term;
        }
        if (term.equals("classes")) {
            return URL + term;
        }
        if (term.equals("feats")) {
            return URL + term;
        }
        if (term.equals("weapons")) {
            return URL + "equipment/" + term;
        }
        if (term.equals("armor")) {
            return URL + "equipment/" + term;
        }
        if (term.equals("start gold")) {
            return URL + "equipment";
        }
        if (term.equals("spells")) {
            return URL + "magic/all-spells";
        }

        String type = getType(term);

        if (term.contains(" ")) {
            term = term.replace(" ", "-");
        }

        if (type == null) {
            return "Term could not be found, the Term either doesn't exist or is not yet implemented into the bot's database. Thank you.";
        }

        if (type.equals("classes/unchained-classes/")) {
            String uclass = term.substring(10);
            term = uclass + "-" + term.substring(0, 10);
        }

        if (term.contains(" ")) {
            term = term.replace(" ", "-");
        }

        return URL + type + term;
    }

    public static String getType(String term) {
        //races
        String[] coreraces = {"dwarf", "elf", "gnome", "half-elf", "half-orc", "halfling", "human"};
        String[] featuredraces = {"aasimar", "catfolk", "dhampir", "drow", "fetchling", "goblin", "hobgoblin", "ifrit",
                                    "kobold", "orc", "oread", "ratfolk", "sylph", "tengu", "tiefling", "undine"};

        //classes
        String[] coreclasses = {"barbarian", "bard", "cleric", "druid", "fighter", "monk", "paladin", "ranger", "rogue", "sorcerer", "wizard"};
        String[] baseclasses = {"alchemist", "cavalier", "gunslinger", "inquisitor", "magus", "oracle", "shifter", "summoner", "vigilante", "witch", "vampire hunter"};
        String[] alternateclasses = {"antipaladin", "ninja", "samurai"};
        String[] hybridclasses = {"arcanist", "bloodrager", "brawler", "hunter", "investigator", "shaman", "skald", "slayer", "swashbuckler", "warpriest"};
        String[] unchainedclasses = {"unchained barbarian", "unchained monk", "unchained rogue", "unchained summoner"};
        String[] occultclasses = {"kineticist", "medium", "mesmerist", "occultist", "psychic", "spiritualist"};

        //races
        for (String s:coreraces) {
            if (term.equals(s)) {
                return "races/core-races/";
            }
        }
        for (String s:featuredraces) {
            if (term.equals(s)) {
                return "races/other-races/featured-races/arg-";
            }
        }

        //classes
        for (String s:coreclasses) {
            if (term.equals(s)) {
                return "classes/core-classes/";
            }
        }
        for (String s:baseclasses) {
            if (term.equals(s)) {
                return "classes/base-classes/";
            }
        }
        for (String s:alternateclasses) {
            if (term.equals(s)) {
                return "classes/alternate-classes/";
            }
        }
        for (String s:hybridclasses) {
            if (term.equals(s)) {
                return "classes/hybrid-classes/";
            }
        }
        for (String s:unchainedclasses) {
            if (term.equals(s)) {
                return "classes/unchained-classes/";
            }
        }
        for (String s:occultclasses) {
            if (term.equals(s)) {
                return "occult-adventures/occult-classes/";
            }
        }
        return null;
    }
}
