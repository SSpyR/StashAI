package net.stashai.databases.dnd;

import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Roll {

    public static String rolls(String diceroll) {
        int mod = 0;
        int i = 3;
        if (diceroll.contains("+")) {
            i = diceroll.indexOf("+");
            mod = Integer.parseInt(diceroll.substring(i+2));
        }
        if (diceroll.contains("-")) {
            i = diceroll.indexOf("-");
            mod = -(Integer.parseInt(diceroll.substring(i+2)));
        }

        Random dice = new Random();
        int nat;

        int k = diceroll.indexOf('d');
        if (k == 0) {
            int die = Integer.parseInt(diceroll.substring((k+1)).replace(" + " + mod, ""));
            nat = dice.nextInt(die) + 1;
            int result = nat + mod;
            return Integer.toString(result) + "\n{" + Integer.toString(nat) + " + " + Integer.toString(mod) + "}";
        }
        else if (k > 0) {
            int die = Integer.parseInt(diceroll.substring((k+1)).replace(" + " + mod, ""));
            int nod = Integer.parseInt(diceroll.substring(0, (k)));
            Integer[] nats = new Integer[nod];
            int allnat = 0;
            for (int j = 1; j <= nod; j++) {
                nats[(j-1)] = (dice.nextInt(die) + 1);
                allnat += nats[(j-1)];
            }
            int results = allnat + mod;
            String natSt[] = Arrays.toString(nats).split("[\\[\\]]")[1].split(", ");
            return Integer.toString(results) + "\n{" + Arrays.toString(natSt) + " + " + Integer.toString(mod) + "}";
        }
        return null;
    }

    public static void rollsDisplay(String diceroll, IMessage message, String roll) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.withAuthorName("Stash AI");
        embed.withAuthorIcon("https://pre00.deviantart.net/3727/th/pre/f/2018/080/8/4/atomic___animated_4k__3840x2160__by_axiomdesign-dc6l17d.jpg");

        embed.withColor(Color.CYAN);
        embed.withTitle("Roll for " + message.getAuthor().getNicknameForGuild(message.getGuild()));
        embed.withDescription("Result: " + diceroll);

        embed.withFooterText("Roll Made: " + roll);

        RequestBuffer.request(() -> message.getChannel().sendMessage(embed.build()));
    }
}
