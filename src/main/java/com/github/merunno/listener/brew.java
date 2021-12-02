package com.github.merunno.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;

public class brew implements Listener {

    @EventHandler
    public void onBrew(BrewEvent brewEvent) {
        Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[AfnwCore] どこかの醸造台での醸造が完了したようだ....");
    }
}
