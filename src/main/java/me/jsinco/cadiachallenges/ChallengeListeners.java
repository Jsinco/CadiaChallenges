package me.jsinco.cadiachallenges;

import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ChallengeListeners implements org.bukkit.event.Listener {

    private final CadiaChallenges plugin = CadiaChallenges.getInstance();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!this.plugin.getSettings().getBlockBreakWhitelist().contains(event.getBlock().getType())) {
            return;
        }

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksBroken = Stats.get().getInt(playerUUID);
        currentBlocksBroken++;
        Stats.get().set(playerUUID, currentBlocksBroken);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!this.plugin.getSettings().getBlockPlaceWhitelist().contains(event.getBlock().getType())) {
            return;
        }

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksPlaced = Stats.get().getInt(playerUUID);
        currentBlocksPlaced++;
        Stats.get().set(playerUUID, currentBlocksPlaced);
    }

}
