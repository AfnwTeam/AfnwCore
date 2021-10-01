package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class quit implements Listener {

    String pluginAfnw = "[AfnwCore] ";

    @EventHandler
    public void onquit(PlayerQuitEvent quitEvent) {
        Player player = quitEvent.getPlayer();
        Location loc = player.getLocation();
        quitEvent.setQuitMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "がAfnwからログアウトしました。");
        quit_sound(loc);
    }

    public void quit_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_BEACON_DEACTIVATE, 1, 1);
    }
}
