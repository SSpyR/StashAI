package net.stashai.events;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.ActivityType;
import sx.blah.discord.handle.obj.StatusType;

import static net.stashai.Bot.logger;

public class ReadyHandler implements IListener<ReadyEvent> {

    @Override
    public void handle(ReadyEvent event) {
        logger.info("BOT STARTUP COMPLETE");
        event.getClient().changePresence(StatusType.ONLINE, ActivityType.PLAYING, "with Databases");
    }
}
