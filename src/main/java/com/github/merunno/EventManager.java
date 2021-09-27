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

import java.util.Objects;

public class EventManager implements Listener {

    String pluginAfnw = "[AfnwCore] ";
    String pluginVersion = "v2.2.5";

    @EventHandler
    public void onjoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        joinEvent.setJoinMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwにログインしました。");
        Location loc = player.getLocation();
        player.sendMessage(ChatColor.WHITE + "Afnwにようこそ！\nアイテムを入手するには投票を行ってください。：" + ChatColor.YELLOW + "/vote-link");
        player.sendTitle(ChatColor.AQUA + "Afnw", ChatColor.WHITE + pluginVersion, 3, 60, 1);
        join_sound(loc);
        player.sendMessage(ChatColor.LIGHT_PURPLE + pluginAfnw + "現在のバージョンは " + ChatColor.YELLOW + pluginVersion + ChatColor.LIGHT_PURPLE + " です。");
        player.sendMessage(ChatColor.LIGHT_PURPLE + "更新情報: https://merunno.github.io/AfnwCore/v2.x/" + pluginVersion + ".html");
    }

    @EventHandler
    public void onquit(PlayerQuitEvent quitEvent) {
        Player player = quitEvent.getPlayer();
        Location loc = player.getLocation();
        quitEvent.setQuitMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwからログアウトしました。");
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
