package me.jsinco.cadiachallenges;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class WhiteList {
    static public List<Material> BBwhiteList = new ArrayList<>();
    static public List<Material> BPwhiteList = new ArrayList<>();


    public static void getWhiteList() {
        List<String> rawBBWhiteList = CadiaChallenges.getPlugin(CadiaChallenges.class).getConfig().getStringList("Whitelist_BlockBreak");
        for (String block : rawBBWhiteList) {
            Material material = Material.getMaterial(block);
            if (material != null) {
                BBwhiteList.add(material);
            }
        }

        List<String> rawBPWhiteList = CadiaChallenges.getPlugin(CadiaChallenges.class).getConfig().getStringList("Whitelist_BlockPlace");
        for (String block : rawBPWhiteList) {
            Material material = Material.getMaterial(block);
            if (material != null) {
                BPwhiteList.add(material);
            }
        }
    }
}
