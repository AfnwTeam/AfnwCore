package com.github.merunno;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager extends JavaPlugin implements Listener {

    String pluginAfnw = "[AfnwCore] ";

    @EventHandler
    public void onjoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        joinEvent.setJoinMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwにログインしました。");
        player.sendMessage("Afnwにようこそ！\nアイテムを入手するには投票を行ってください。：" + ChatColor.YELLOW + "/vote-link");
    }

    @EventHandler
    public void onquit(PlayerQuitEvent quitEvent) {
        Player player = quitEvent.getPlayer();
        quitEvent.setQuitMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwからログアウトしました。");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent deathEvent) {
        String deathMsg = deathEvent.getDeathMessage();
        deathEvent.setDeathMessage(ChatColor.RED + pluginAfnw + deathMsg);
    }
}
