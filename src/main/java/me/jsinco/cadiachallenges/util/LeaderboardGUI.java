package me.jsinco.cadiachallenges.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class LeaderboardGUI {
    private static Inventory inv = Bukkit.createInventory(null, 27, ColorUtils.translateColorCodes("&#42fb24&lC&#40f524&lu&#3eef25&lb&#3be925&le&#39e325&lC&#37de26&la&#35d826&ld&#33d227&li&#30cc27&la &#2ec627&lT&#2cc028&lo&#2aba28&lu&#27b428&lr&#25ae29&ln&#23a829&la&#21a32a&lm&#1f9d2a&le&#1c972a&ln&#1a912b&lt&#188b2b&ls"));
    public static Inventory createGUI() {return inv;}

    public static void initializeItems(){
        for (int i = 0; i < inv.getSize(); i++){
            inv.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        inv.setItem(1, createGuiItem(new ItemStack(Material.DIAMOND, 1), "&b&l1st Place", "&7&l" + Leaderboard.num1));
    }

    protected static ItemStack createGuiItem(ItemStack itemStack, String name, String... lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    //stopping here for tonight
}
