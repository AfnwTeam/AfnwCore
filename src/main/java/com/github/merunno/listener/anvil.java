package com.github.merunno.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class anvil implements Listener {

    @EventHandler
    public void onPrepare(PrepareAnvilEvent prepareEvent) {
        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "[AfnwCore] どこかの金床での作業が完了したようだ....");
    }
}
