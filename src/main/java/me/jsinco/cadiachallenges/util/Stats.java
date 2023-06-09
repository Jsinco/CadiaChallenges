package me.jsinco.cadiachallenges.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class Stats {
    private static File file;
    private static FileConfiguration customFile;

    //Finds or generates YAML stats
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CadiaChallenges").getDataFolder(), "Stats.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //ow
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }


}