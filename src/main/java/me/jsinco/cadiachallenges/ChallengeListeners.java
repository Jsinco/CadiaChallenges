package me.jsinco.cadiachallenges;

import me.jsinco.cadiachallenges.config.YMLConfig;
import me.jsinco.cadiachallenges.util.Stats;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;

public class ChallengeListeners implements Listener {

    private final CadiaChallenges plugin = CadiaChallenges.getInstance();
    private final YMLConfig config = plugin.getFiles().get("config");
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!config.string("TourneyMode").equals("block-break")) return;
        if (!this.plugin.getSettings().getBlockBreakWhitelist().contains(event.getBlock().getType()) &&
                !this.plugin.getSettings().getBlockBreakWhitelist().isEmpty()) return;

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksBroken = Stats.get().getInt(playerUUID);
        currentBlocksBroken++;
        Stats.get().set(playerUUID, currentBlocksBroken);
        Stats.save();


    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!config.string("TourneyMode").equals("block-place")) return;
        if (!this.plugin.getSettings().getBlockPlaceWhitelist().contains(event.getBlock().getType()) &&
                !this.plugin.getSettings().getBlockPlaceWhitelist().isEmpty()) return;

        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentBlocksPlaced = Stats.get().getInt(playerUUID);
        currentBlocksPlaced++;
        Stats.get().set(playerUUID, currentBlocksPlaced);
    }

    @EventHandler
    public void onEntityKill(EntityDeathEvent event) {
        if (!config.string("TourneyMode").equals("entity-kill")) return;
        if (!this.plugin.getSettings().getEntityWhitelist().contains(event.getEntity().getType()) &&
        !this.plugin.getSettings().getEntityWhitelist().isEmpty()) return;

        String playerUUID = event.getEntity().getKiller().getUniqueId().toString();

        int currentEntitiesKilled = Stats.get().getInt(playerUUID);
        currentEntitiesKilled++;
        Stats.get().set(playerUUID, currentEntitiesKilled);
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){
        if (!config.string("TourneyMode").equals("fish")) return;
        if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH) return;
        String playerUUID = event.getPlayer().getUniqueId().toString();

        int currentFishCaught = Stats.get().getInt(playerUUID);
        currentFishCaught++;
        Stats.get().set(playerUUID, currentFishCaught);
    }
}
