package net.stashai.databases.dnd;

import java.util.Arrays;
import java.util.Random;

//TODO Fix modifiers implementation
public class StatRolls {

    private static int[] score = new int[6];

    public static String[] rolls() {
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

    /*public static String[] modifiers() {
        int[] mod = new int[6];
        String[] mods;

        for (int k = 0; k < score.length; k++) {
            int a = 20;
            int m = 5;
            while (a != score[k]) {
                a = a-2;
                m--;
            }
            mod[k] = m;
        }

        mods = Arrays.toString(mod).split("[\\[\\]]")[1].split(", ");

        return mods;
    }*/

    private static int statRoll() {
        int score;

        Random roll = new Random();
        int dice1 = roll.nextInt(6) + 1;
        int dice2 = roll.nextInt(6) + 1;
        int dice3 = roll.nextInt(6) + 1;
        int dice4 = roll.nextInt(6) + 1;

        if (dice1 <= dice2 && dice1 <= dice3 && dice1 <= dice4) {
            score = dice2 + dice3 + dice4;
        }
        else if (dice2 <= dice1 && dice2 <= dice3 && dice2 <= dice4) {
            score = dice1 + dice3 + dice4;
        }
        else if (dice3 <= dice1 && dice3 <= dice1 && dice3 <= dice4) {
            score = dice1 + dice2 + dice4;
        }
        else if (dice4 <= dice1 && dice4 <= dice2 && dice4 <= dice3) {
            score = dice1 + dice2 + dice3;
        }
        else {
            return 0;
        }
        return score;
    }
}
