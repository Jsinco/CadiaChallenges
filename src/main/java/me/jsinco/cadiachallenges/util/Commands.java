package me.jsinco.cadiachallenges.util;

import me.jsinco.cadiachallenges.Settings;
import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Leaderboard.LeaderboardCalculate();
        Stats.save(); //reload
        Stats.reload();
        Settings settings = new Settings();
        settings.cache();
        commandSender.sendMessage("Challenges reloaded");
        return true;
    }
}
