package net.stashai.events;

import net.stashai.Bot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.obj.IRole;

public class NewUserHandler implements IListener<UserJoinEvent> {

    @Override
    public void handle(UserJoinEvent event) {
        Bot.logger.info(event.getGuild().toString());
        if (event.getGuild().getLongID() == 505784635431714826L) {
            IRole role = event.getGuild().getRoleByID(505792791897571355L);
            event.getUser().addRole(role);
        }
    }
}
