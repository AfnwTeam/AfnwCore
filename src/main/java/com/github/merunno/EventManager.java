package com.github.merunno;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class EventManager implements Listener {

    String pluginAfnw = "[AfnwCore] ";
    String pluginVersion = "v3.0.0";


    @EventHandler
    public void onjoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        Inventory player_inventory = player.getInventory();
        Location loc = player.getLocation();
        int emptySlot = player_inventory.firstEmpty();
        player.sendTitle(ChatColor.AQUA + "Afnw", ChatColor.WHITE + pluginVersion, 3, 60, 1);
        player.sendMessage("Afnwにようこそ！\nアイテムを入手するには投票を行ってください。： " + ChatColor.YELLOW + "/vote-link");
        player.sendMessage("現在のバージョンは " + ChatColor.YELLOW + pluginVersion + ChatColor.WHITE + " です。");
        player.sendMessage("更新情報: https://merunno.github.io/AfnwCore/");
        joinEvent.setJoinMessage(ChatColor.GRAY + player.getName() + "がAfnwにログインしました。");
        join_sound(loc);
        if(emptySlot == -1) {
            player.sendMessage(ChatColor.RED + pluginAfnw + "警告： \nインベントリがいっぱいで空きがないです。この状態で投票してもアイテムを受け取れません。インベントリを整理したあとに投票を行ってください。");
        }
    }

    @EventHandler
    public void onquit(PlayerQuitEvent quitEvent) {
        Player player = quitEvent.getPlayer();
        Location loc = player.getLocation();
        quitEvent.setQuitMessage(ChatColor.GRAY + player.getName() + "がAfnwからログアウトしました。");
        quit_sound(loc);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent deathEvent) {
        String deathMsg = deathEvent.getDeathMessage();
        deathEvent.setDeathMessage(ChatColor.RED + pluginAfnw + "プレイヤーが死亡しました。：" + deathMsg);
    }

    public void join_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
    }

    public void quit_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_BEACON_DEACTIVATE, 1, 1);
    }
}
