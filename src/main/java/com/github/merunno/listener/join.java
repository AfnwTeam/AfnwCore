package com.github.merunno.listener;

import com.sun.tools.javac.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class join implements Listener {

    String pluginAfnw = "[AfnwCore] ";
    String pluginVersion = "v3.6.0";
    String pluginStar = ChatColor.YELLOW + "★" + ChatColor.WHITE;

    @EventHandler
    public void onjoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        Inventory player_inventory = player.getInventory();
        Location loc = player.getLocation();
        int emptySlot = player_inventory.firstEmpty();

        player.sendTitle(ChatColor.AQUA + "Afnw", "この世界にあるのは、 岩盤一つだけ。", 3, 60, 1);
        player.sendMessage(ChatColor.YELLOW + "Afnwにようこそ！");
        player.sendMessage(pluginStar + "アイテムの入手 → " + ChatColor.YELLOW + "/vote");
        player.sendMessage(pluginStar + "現在のバージョン → " + ChatColor.YELLOW + pluginVersion);
        player.sendMessage(pluginStar + "アジ鯖Discord → " + ChatColor.YELLOW + "https://discord.gg/azisaba");
        player.sendMessage(pluginStar + "Afnwルール → " + ChatColor.YELLOW + "https://www.azisaba.net/server-intro/a-fall-new-world/#rule");
        join_sound(loc);

        if (emptySlot == -1) {
            player.sendMessage(ChatColor.RED + pluginAfnw + "インベントリがいっぱいで空きがないです。この状態で投票してもアイテムを受け取れません。インベントリを整理したあとに投票を行ってください。");
        }

        if (player.hasPermission("afnw.op.commands")) {
            joinEvent.setJoinMessage(ChatColor.GRAY + "[AfnwCore] 権限所有者(Admin) - " + player.getName() + "がAfnwにログインしました。");
            return;
        }

        joinEvent.setJoinMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwにログインしました。");

    }

    public void join_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
    }
}
