package com.github.merunno.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class move implements Listener {

    @EventHandler
    public void onMove(PlayerChangedWorldEvent worldEvent) {
        Player player = worldEvent.getPlayer();
        World world = player.getWorld();
        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "[AfnwCore] " + ChatColor.YELLOW + player.getName() + ChatColor.WHITE + "が" + ChatColor.YELLOW +  world.getName() + ChatColor.WHITE + "に移動しました。");
    }
}
