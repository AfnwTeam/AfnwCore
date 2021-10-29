package com.github.merunno.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.util.Objects;

public class join implements Listener {

    String pluginAfnw = "[AfnwCore] ";
    String pluginVersion = "v3.0.0";
    String pluginStar = ChatColor.YELLOW + "★" + ChatColor.WHITE;

    @EventHandler
    public void onplayerSpawn(PlayerSpawnLocationEvent spawnLocationEvent) {
        Player player = spawnLocationEvent.getPlayer();
        Bukkit.broadcastMessage("Waiting for connection....");
        player.sendMessage(pluginAfnw + "Connecting....");
    }

    @EventHandler
    public void onjoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        Inventory player_inventory = player.getInventory();
        Location loc = player.getLocation();
        int emptySlot = player_inventory.firstEmpty();

        player.sendTitle(ChatColor.AQUA + "Afnw", null, 3, 60, 1);
        player.sendMessage(ChatColor.YELLOW + "Afnwにようこそ！");
        player.sendMessage(pluginStar + "アイテムの入手 → " + ChatColor.YELLOW + "/afnwcore vote");
        player.sendMessage(pluginStar + "現在のバージョン → " + ChatColor.YELLOW + pluginVersion);
        player.sendMessage(pluginStar + "更新情報 → " + ChatColor.YELLOW + "https://afnwcore.merunno.dev/");

        joinEvent.setJoinMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwにログインしました。");
        join_sound(loc);

        if (emptySlot == -1) {
            player.sendMessage(ChatColor.RED + pluginAfnw + "インベントリがいっぱいで空きがないです。この状態で投票してもアイテムを受け取れません。インベントリを整理したあとに投票を行ってください。");
        }
    }

    public void join_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
    }
}
