package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class saplingBreakCanceller implements Listener {

    String prefix = "[AfnwCore] ";

    @EventHandler
    public void onBreakSapling(BlockBreakEvent breakEvent) {
        Player player = breakEvent.getPlayer();
        if (breakEvent.getBlock().getType().name().contains("SAPLING")) {
            if (player.hasPermission("afnw.op.commands")) {
                player.sendMessage(ChatColor.YELLOW + prefix + "オペレーター権限で苗木を破壊しました。");
                return;
            }
            breakEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AfnwCore] " + "一度設置した苗木は破壊できません。破壊の申請はサーバー内にいる運営に連絡してください。");
        }
    }
}
