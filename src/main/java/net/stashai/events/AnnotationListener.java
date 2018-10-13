package net.stashai.events;

import net.stashai.Bot;
import net.stashai.commands.Command;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;

import java.util.HashMap;

public class AnnotationListener {

    private Command Command = new Command();
    private IMessage message;

    //TODO commands not working, debug
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

    HashMap<String, Runnable> hmap;

    public AnnotationListener() {
        this.hmap = new HashMap<String, Runnable>() {
            {
                put("?help", () -> Command.help(message));
                put("?destiny", () -> Command.destiny(message));
            }
        };
    }
}
