package me.jsinco.cadiachallenges.util;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Leaderboard {

    static public int num1;
    static public int num2;
    static public int num3;


    public static void LeaderboardCalculate(){
        Set<String> scoresRaw = Stats.get().getKeys(false);
        List<String> scoresRawList = new ArrayList<>(scoresRaw);
        List<Integer> scores = new ArrayList<>();
        for (String score : scoresRawList){
            scores.add(Stats.get().getInt(score));
        }

        scores.sort(Collections.reverseOrder());

        try {
            int num1 = scores.get(0);
            int num2 = scores.get(1);
            int num3 = scores.get(2);
        } catch (Exception e) {
            Bukkit.getLogger().info("Not enough players for leaderboard");
        }
    }

}
