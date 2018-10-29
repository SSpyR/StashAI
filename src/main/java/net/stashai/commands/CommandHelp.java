package net.stashai.commands;

import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.awt.*;

class CommandHelp {

    static void list(IMessage message) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.withAuthorName("Stash AI");
        embed.withAuthorIcon("https://pre00.deviantart.net/3727/th/pre/f/2018/080/8/4/atomic___animated_4k__3840x2160__by_axiomdesign-dc6l17d.jpg");

        embed.withColor(Color.CYAN);
        embed.withTitle("List of Commands");
        embed.withDescription("Commands currently able to used and processed with the Stash AI bot");

        embed.appendField("General Commands", "help"
                + "\n"
                + "about"
                + "\n"
                + "github"
                + "\n"
                + "invite/inv"
                + "\n"
                + "supinv", true);
        embed.appendField("Game Commands", "destiny/d2 (item)"
                + "\n"
                + "wow (item)"
                + "\n"
                + "maplestory/mp2 (term)"
                + "\n"
                + "battlerite/br (champ)"
                + "\n"
                + "brbuilds (champ)", true);
        embed.appendField("D&D Commands", "5e/dnd (term)"
                + "\n"
                + "pathfinder/pf (term)"
                + "\n"
                + "rollstats"
                + "\n"
                + "roll (dice roll + mods)", true);

        embed.withFooterText("Stash AI | Created by Angel LaVoie aka Keiosu");

        RequestBuffer.request(() -> message.getClient().getOrCreatePMChannel(message.getAuthor()).sendMessage(embed.build()));
    }
}
