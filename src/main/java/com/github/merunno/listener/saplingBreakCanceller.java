package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;

public class saplingBreakCanceller implements Listener {

    String prefix = "[AfnwCore] ";

    @EventHandler
    public void onBreakSapling(BlockBreakEvent breakEvent) {
        Player player = breakEvent.getPlayer();
        if (Tag.SAPLINGS.isTagged(breakEvent.getBlock().getType()) && !(breakEvent.getBlock().getType() == Material.FLOWERING_AZALEA || breakEvent.getBlock().getType() == Material.FLOWERING_AZALEA_LEAVES)) {
            if (player.hasPermission("afnw.op.commands")) {
                player.sendMessage(ChatColor.YELLOW + prefix + "オペレーター権限で苗木を破壊しました。");
                return;
            }
            breakEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AfnwCore] " + "一度設置した苗木は破壊できません。破壊の申請はサーバー内にいる運営に連絡してください。");
        } else if(Tag.SAPLINGS.isTagged(breakEvent.getBlock().getLocation().add(0, 1, 0).getBlock().getType())) {
            breakEvent.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[AfnwCore] " + "苗木が植えられている土は破壊できません。苗木が育ち切るのを待つか、苗木の破壊を運営に申請してください。");
        }
    }

    /**
     * 苗木に対して水流が流れ込むのを阻害する
     */
    @EventHandler
    public void onFlowing(BlockFromToEvent event){
        if (Tag.SAPLINGS.isTagged(event.getToBlock().getType()) && !(event.getToBlock().getType() == Material.FLOWERING_AZALEA || event.getToBlock().getType() == Material.FLOWERING_AZALEA_LEAVES)) {
            event.setCancelled(true);
        }
    }
}
