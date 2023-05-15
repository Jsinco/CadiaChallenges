package me.jsinco.cadiachallenges;

import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void PlayerBreak(BlockBreakEvent event){
        if (!WhiteList.BBwhiteList.contains(event.getBlock().getType())) return;

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksBroken = Stats.get().getInt(playerUUID);
        currentBlocksBroken++;
        Stats.get().set(playerUUID, currentBlocksBroken);
    }

    @EventHandler
    public void PlayerPlace(BlockPlaceEvent event){
        if (!WhiteList.BPwhiteList.contains(event.getBlock().getType())) return;

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksPlaced = Stats.get().getInt(playerUUID);
        currentBlocksPlaced++;
        Stats.get().set(playerUUID, currentBlocksPlaced);
    }

}
