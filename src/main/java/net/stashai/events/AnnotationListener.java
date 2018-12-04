package net.stashai.events;

import net.stashai.Bot;
import net.stashai.commands.Command;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;

import java.util.HashMap;

import static net.stashai.Bot.logger;

public class AnnotationListener {

    private Command Command = new Command();
    private IMessage message;

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event) {
        message = event.getMessage();
        if (message.toString().startsWith(Bot.BOT_PREFIX)) {
            String[] arr = message.toString().split(" ");
            if(hmap.containsKey(arr[0].toLowerCase())) {
                hmap.get(arr[0].toLowerCase()).run();
            }
        }
    }

    private HashMap<String, Runnable> hmap;

    public AnnotationListener() {
        logger.info("EVENT LISTENER AND COMMANDS REGISTERED");

        this.hmap = new HashMap<String, Runnable>() {
            {
                put("?shutdown", () -> Command.shutdown(message));
                put("?about", () -> Command.about(message));
                put("?help", () -> Command.help(message));
                put("?github", () -> Command.github(message));
                put("?invite", () -> Command.invite(message));
                put("?inv", () -> Command.invite(message));
                put("?supinv", () -> Command.supinv(message));
                put("?destiny", () -> Command.destiny(message));
                put("?d2", () -> Command.destiny(message));
                put("?wow", () -> Command.wow(message));
                put("?vanilla", () -> Command.vanilla(message));
                put("?maplestory", () -> Command.maplestory(message));
                put("?mp2", () -> Command.maplestory(message));
                put("?mhw", () -> Command.mhw(message));
                put("?pathfinder", () -> Command.pathfinder(message));
                put("?pf", () -> Command.pathfinder(message));
                put("?5e", () -> Command.fiveE(message));
                put("?dnd", () -> Command.fiveE(message));
                put("?rollstats", () -> Command.statRolls(message));
                put("?rs", () -> Command.statRolls(message));
                put("?roll", () -> Command.roll(message));
                put("?rage", () -> Command.rage(message));
                put("?battlerite", () -> Command.battleRite(message));
                put("?br", () -> Command.battleRite(message));
                put("?brbuilds", () -> Command.brBuilds(message));
                put("?wiki", () -> Command.wiki(message));
            }
        };
    }
}
