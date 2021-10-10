package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class death implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent deathEvent) {
        String deathMsg = deathEvent.getDeathMessage();
        deathEvent.setDeathMessage(ChatColor.RED + deathMsg);
    }
}
