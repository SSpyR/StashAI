package net.stashai.commands;

import net.stashai.Bot;
import net.stashai.databases.MaplestorySearch;
import net.stashai.databases.dnd.FiveESearch;
import net.stashai.databases.dnd.PathfinderSearch;
import net.stashai.databases.dnd.StatRolls;
import net.stashai.databases.battlerite.BattleriteSearch;
import net.stashai.databases.battlerite.BrBuildsSearch;
import net.stashai.databases.DestinySearch;
import net.stashai.databases.WoWSearch;
import sx.blah.discord.handle.obj.IMessage;

import java.util.Arrays;

public class Command {

    private String s = "";

    //General Commands
    public void help(IMessage message) {
        CommandHelp.list(message);
        message.getChannel().sendMessage("A list of commands have been sent to you!");
    }

    public void about(IMessage message) {
        CommandAbout.desc(message);
    }

    public void github(IMessage message) {
        message.getClient().getOrCreatePMChannel(message.getAuthor()).sendMessage("Here is the GitHub link for the Bot: https://github.com/K3io5u/StashAI"
                + "\n"
                + "(If you wish to contribute to this project, feel free to email stashaibot@gmail.com)");
        message.getChannel().sendMessage("The GitHub link has been sent to you!");
    }

    public void invite(IMessage message) {
        message.getClient().getOrCreatePMChannel(message.getAuthor()).sendMessage("Here is an invite link for Stash AI: https://discordapp.com/api/oauth2/authorize?client_id=491779560577433609&permissions=36883520&scope=bot");
        message.getChannel().sendMessage("A bot invite link has been sent to you!");
    }

    public void supinv(IMessage message) {
        message.getClient().getOrCreatePMChannel(message.getAuthor()).sendMessage("Here is an invite link to the Stash AI server: https://discord.gg/WGvD4vV");
        message.getChannel().sendMessage("A server invite link has been sent to you!");
    }

    public void shutdown(IMessage message) {
        if (message.getAuthor().getStringID().equals("98200921950920704")) {
            message.getChannel().sendMessage("Shutting down...");
            message.getClient().logout();
            Bot.logger.info("BOT SHUTDOWN BY USER");
        }
        else {
            message.getChannel().sendMessage("You are not authorized to use that command.");
        }
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

    //MapleStory 2
    public void maplestory(IMessage message) {
        if (message.toString().contains("?maplestory")) {
            s = (message.getContent().toLowerCase().replace("?maplestory ".toLowerCase(), ""));
        }
        if (message.toString().contains("?mp2")) {
            s = (message.getContent().toLowerCase().replace("?mp2 ".toLowerCase(), ""));
        }
        message.reply(MaplestorySearch.search(s));
        message.getChannel().sendMessage("(Pages provided by Maplestory 2 Gamepedia)");
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
        if (message.toString().contains("?5e")) {
            s = (message.getContent().toLowerCase().replace("?5e ".toLowerCase(), ""));
        }
        if (message.toString().contains("?dnd")) {
            s = (message.getContent().toLowerCase().replace("?dnd ".toLowerCase(), ""));
        }
        message.reply(FiveESearch.search(s));
        message.getChannel().sendMessage("(Pages provided by roll20)");
    }

    public void statRolls(IMessage message) {
        message.reply("Ability Scores: " + Arrays.toString(StatRolls.rolls()));
        message.reply("Ability Modifiers: " + Arrays.toString(StatRolls.modifiers()));
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
