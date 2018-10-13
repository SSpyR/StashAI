package net.stashai.commands;

import net.stashai.utils.DestinySearch;
import sx.blah.discord.handle.obj.IMessage;

public class Command {

    private String s = "";

    public void help(IMessage message) {
        message.getChannel().sendMessage("**Current Commands** \n"
                + "\n"
                + "help"
                + "\n"
                + "destiny (item)");
    }

    public void destiny(IMessage message) {
        s = (message.getContent().toLowerCase().replace("?destiny ".toLowerCase(), ""));
        message.reply(DestinySearch.search(s));
    }
}
