package net.stashai.databases.dnd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class StatRolls {

    private static int[] score = new int[6];

    public static String[] scorerolls() {
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
}
