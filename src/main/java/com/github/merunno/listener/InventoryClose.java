package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;


public class InventoryClose implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent closeEvent) {
        Player player = (Player) closeEvent.getPlayer();
        player.sendMessage(ChatColor.RED + "[AfnwCore] インベントリがいっぱいです。");
    }
}
