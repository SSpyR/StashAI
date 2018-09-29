package net.stashai.events;

import net.stashai.utils.Utils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class Events {

    @EventSubscriber
    public void onMessageRecieved(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith(Utils.BOT_PREFIX + "test"))
            Utils.sendMessage(event.getChannel(), "I am sending a message from an EventSubscriber listener");
    }
}
