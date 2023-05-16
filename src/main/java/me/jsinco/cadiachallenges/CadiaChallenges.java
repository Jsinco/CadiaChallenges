package me.jsinco.cadiachallenges;

import lombok.Getter;
import me.jsinco.cadiachallenges.config.YMLConfig;
import me.jsinco.cadiachallenges.config.registry.FilesRegistry;
import me.jsinco.cadiachallenges.util.Commands;
import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

@Getter
public final class CadiaChallenges extends JavaPlugin {

    private static CadiaChallenges instance;

    public static CadiaChallenges getInstance() {
        return instance;
    }

    private FilesRegistry files;
    private Settings settings;

    /*
    static final YMLConfig config = instance.getFiles().get("config");
    static public String TourneyMode = config.string("TourneyMode");
     */

    @Override
    public void onEnable() {

        instance = this;

        this.files = new FilesRegistry(this)
                .createFile("config");
        this.settings = new Settings();

        Stats.setup();
        Stats.save();

        getServer().getPluginManager().registerEvents(new ChallengeListeners(), this);
        getCommand("statsreload").setExecutor(new Commands());

        /*
        Date date = new Date();
        if (getDayofWeek(date) == 2){
            String[] modes = new String[]{"block-break", "block-place", "entity-kill", "fish"};
            Random rand = new Random();
            int random = rand.nextInt(modes.length);
            config.string("TourneyMode", modes[random]);
        }

         */
    }

    @Override
    public void onDisable() {
        Stats.save();
    }

    /*
    public static int getDayofWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    */
}
