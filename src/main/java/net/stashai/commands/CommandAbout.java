package net.stashai.commands;

import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.awt.*;

class CommandAbout {

    static void desc(IMessage message) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.withAuthorName("Stash AI");
        embed.withAuthorIcon("https://pre00.deviantart.net/3727/th/pre/f/2018/080/8/4/atomic___animated_4k__3840x2160__by_axiomdesign-dc6l17d.jpg");

        embed.withColor(Color.CYAN);
        embed.withTitle("About Stash AI");
        embed.withDescription("Stash AI is a Discord bot whose purpose"
                + "\n"
                + "is to provide direct links to databases"
                + "\n"
                + "for items in games, specifically MMO types (not limited to though)"
                + "\n"
                + "This bot also has options for getting information"
                + "\n"
                + "for D&D purposes and making rolls for said RPG");

        embed.withFooterText("Stash AI | Created by Angel LaVoie aka Keiosu");

        RequestBuffer.request(() -> message.getChannel().sendMessage(embed.build()));
    }
}
