package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

public class saplingBreakCanceller implements Listener {

    @EventHandler
    public void onBreakSapling(BlockBreakEvent breakEvent) {
        Item item = (Item) breakEvent.getBlock();
        Player player = breakEvent.getPlayer();
        List<Material> materials = Arrays.asList(Material.values());
        if(item.hasMetadata(String.valueOf(materials))) {
            breakEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AfnwCore] " + "一度設置した苗木は破壊できません。");
        }
    }

    private static boolean isAllowed(Material type) {
        switch (type) {
            case OAK_SAPLING:
            case SPRUCE_SAPLING:
            case BIRCH_SAPLING:
            case JUNGLE_SAPLING:
            case ACACIA_SAPLING:
            case DARK_OAK_SAPLING: return false;
            default: return true;
        }
    }
}
