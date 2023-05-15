package me.jsinco.cadiachallenges;

import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.plugin.java.JavaPlugin;

public final class CadiaChallenges extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().getDefaults();
        saveDefaultConfig();

        Stats.setup();

        WhiteList.getWhiteList();

        getServer().getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
        Stats.save();
    }
}
