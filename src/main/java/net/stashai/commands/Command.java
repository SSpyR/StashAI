package net.stashai.commands;

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
                + "destiny (item)"
                + "\n"
                + "wow (item)");
    }

    public void about(IMessage message) {
        message.getChannel().sendMessage("**About Stash AI** \n"
                + "\n"
                + "Stash AI is a Discord bot whose purpose"
                + "\n"
                + "is to provide direct links to databases"
                + "\n"
                + "for items in games, specifically MMO types");
    }

    public void destiny(IMessage message) {
        s = (message.getContent().toLowerCase().replace("?destiny ".toLowerCase(), ""));
        message.reply(DestinySearch.search(s));
        message.getChannel().sendMessage("(Search Engine provided by Planet Destiny)");
    }

    public void wow(IMessage message) {
        s = (message.getContent().toLowerCase().replace("?wow ".toLowerCase(), ""));
        message.reply(WoWSearch.search(s));
        message.getChannel().sendMessage("(Search Engine provided by WoWHead)");
    }
}
