package com.github.merunno.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent playerChatEvent) {
        Player player = playerChatEvent.getPlayer();
        String world = player.getWorld().getName();
        String message = playerChatEvent.getMessage();
        playerChatEvent.setMessage(message + ChatColor.LIGHT_PURPLE + " @" + world);
    }
}
