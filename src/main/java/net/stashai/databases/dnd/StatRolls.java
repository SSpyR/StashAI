package net.stashai.databases.dnd;

import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class StatRolls {

    private static int[] score = new int[6];

    public static String[] scoreRolls() {
        String[] scores;

        for (int i = 0; i < score.length; i++) {
            score[i] = statRoll();
            if (score[i] < 3) {
                return null;
            }
        }

        scores = Arrays.toString(score).split("[\\[\\]]")[1].split(", ");

        return scores;
    }

    public static String[] modifiers() {
        int[] mod = new int[6];
        String[] mods;

        for (int k = 0; k < score.length; k++) {
            int m = ((score[k])/2) - 5;
            mod[k] = m;
        }

        mods = Arrays.toString(mod).split("[\\[\\]]")[1].split(", ");

        return mods;
    }

    private static int statRoll() {
        Random roll = new Random();
        Integer[] ability = {(roll.nextInt(6)+1), (roll.nextInt(6)+1), (roll.nextInt(6)+1), (roll.nextInt(6)+1)};

        Arrays.sort(ability, Collections.reverseOrder());
        return ability[0] + ability[1] + ability[2];
    }

    public static void scoreDisplay(String scores, String mods, IMessage message) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.withAuthorName("Stash AI");
        embed.withAuthorIcon("https://pre00.deviantart.net/3727/th/pre/f/2018/080/8/4/atomic___animated_4k__3840x2160__by_axiomdesign-dc6l17d.jpg");

        embed.withColor(Color.CYAN);
        embed.withTitle("Stat Rolls for " + message.getAuthor().getNicknameForGuild(message.getGuild()));
        embed.withDescription("Ability Scores: " + scores + "\nModifiers: " + mods);

        RequestBuffer.request(() -> message.getChannel().sendMessage(embed.build()));
    }
}
