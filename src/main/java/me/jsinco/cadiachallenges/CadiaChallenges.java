package me.jsinco.cadiachallenges;

import lombok.Getter;
import me.jsinco.cadiachallenges.config.registry.FilesRegistry;
import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class CadiaChallenges extends JavaPlugin {

    private static CadiaChallenges instance;

    public static CadiaChallenges getInstance() {
        return instance;
    }

    private FilesRegistry files;
    private Settings settings;

    @Override
    public void onEnable() {

        instance = this;

        this.files = new FilesRegistry(this)
                .createFile("config");
        this.settings = new Settings();

        Stats.setup();

        getServer().getPluginManager().registerEvents(new ChallengeListeners(), this);
    }

    @Override
    public void onDisable() {
        Stats.save();
    }
}
