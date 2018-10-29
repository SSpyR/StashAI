package net.stashai.databases.dnd;

import java.util.Random;

public class Roll {

    public static String rolls(String diceroll) {
        int mod = 0;
        if (diceroll.contains("+")) {
            int i = diceroll.indexOf("+");
            mod = Integer.parseInt(diceroll.substring(i+2, i+3));
        }
        if (diceroll.contains("-")) {
            int i = diceroll.indexOf("-");
            mod = -(Integer.parseInt(diceroll.substring(i+2, i+3)));
        }

        int die = Integer.parseInt(diceroll.substring(0, 2));

        Random dice = new Random();
        int nat = dice.nextInt(die) + 1;

        int result = nat + mod;

        return Integer.toString(result) + "\n[" + Integer.toString(nat) + " + " + Integer.toString(mod) + "]";
    }
}
