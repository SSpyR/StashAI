package net.stashai.commands;

import net.stashai.dnd.PathfinderSearch;
import net.stashai.dnd.StatRolls;
import net.stashai.utils.BattleriteSearch;
import net.stashai.utils.BrBuildsSearch;
import net.stashai.utils.DestinySearch;
import net.stashai.utils.WoWSearch;
import sx.blah.discord.handle.obj.IMessage;

public class Command {

    private String s = "";

    public void help(IMessage message) {
        message.getChannel().sendMessage("**Current Commands** \n"
                + "\n"
                + "help"
                + "\n"
                + "about"
                + "\n"
                + "destiny or d2 (item)"
                + "\n"
                + "wow (item)"
                + "\n"
                + "pathfinder or pf (term)"
                + "\n"
                + "5e or dnd (term)"
                + "\n"
                + "rollstats or rs"
                + "\n"
                + "battlerite or br (champ)"
                + "\n"
                + "brbuilds (champ)");
    }

    public void about(IMessage message) {
        message.getChannel().sendMessage("**About Stash AI** \n"
                + "\n"
                + "Stash AI is a Discord bot whose purpose"
                + "\n"
                + "is to provide direct links to databases"
                + "\n"
                + "for items in games, specifically MMO types (not limited to though)"
                + "\n"
                + "This bot also has options for getting information"
                + "\n"
                + "for D&D purposes and making rolls for said RPG"
                + "\n"
                + "*{Made by Angel LaVoie aka Keiosu}*");
    }

    //Destiny 2
    public void destiny(IMessage message) {
        if (message.toString().contains("?destiny")) {
            s = (message.getContent().toLowerCase().replace("?destiny ".toLowerCase(), ""));
        }
        if (message.toString().contains("?d2")) {
            s = (message.getContent().toLowerCase().replace("?d2 ".toLowerCase(), ""));
        }
        message.reply(DestinySearch.search(s));
        message.getChannel().sendMessage("(Search Engine provided by Planet Destiny)");
    }

    //World of Warcraft
    public void wow(IMessage message) {
        s = (message.getContent().toLowerCase().replace("?wow ".toLowerCase(), ""));
        message.reply(WoWSearch.search(s));
        message.getChannel().sendMessage("(Search Engine provided by WoWHead)");
    }

    //Dungeons and Dragons
    public void pathfinder(IMessage message) {
        if (message.toString().contains("?pathfinder")) {
            s = (message.getContent().toLowerCase().replace("?pathfinder ".toLowerCase(), ""));
        }
        if (message.toString().contains("?pf")) {
            s = (message.getContent().toLowerCase().replace("?pf ".toLowerCase(), ""));
        }
        message.reply(PathfinderSearch.search(s));
        message.getChannel().sendMessage("(Pages provided by d20pfsrd)");
    }

    public void fiveE(IMessage message) {

    }

    public void statRolls(IMessage message) {
        message.reply(StatRolls.rolls());
    }

    //Battlerite
    public void battleRite(IMessage message) {
        if (message.toString().contains("?battlerite")) {
            s = (message.getContent().toLowerCase().replace("?battlerite ".toLowerCase(), ""));
        }
        if (message.toString().contains("?br")) {
            s = (message.getContent().toLowerCase().replace("?br ".toLowerCase(), ""));
        }
        message.reply(BattleriteSearch.search(s));
        message.getChannel().sendMessage("(Guides provided by Topplerite)");
    }

    public void brBuilds(IMessage message) {
        if (message.toString().contains("?brbuilds")) {
            s = (message.getContent().toLowerCase().replace("?brbuilds ".toLowerCase(), ""));
        }
        message.reply(BrBuildsSearch.buildSearch(s));
        message.getChannel().sendMessage("(Builds provided by BattleriteBuilds)");
    }
}
